package routing;

import history.*;
import neighbor.*;
import org.newsclub.net.unix.*;

import java.io.*;
import java.nio.channels.*;
import java.util.*;

/**
 * A simple implementation of router, which only supports the following messages:
 * - Data
 * - Dump
 * - No Route
 * - Route Update
 * - Table
 */
public class SimpleRouter implements Router {
    
    // The list of neighbors of this router, which will not change since routes cannot be revoked
    private final List<Neighbor> neighbors;
    // The forwarding table for maintaining paths to destinations
    private ForwardingTable forwardingTable;
    // The update history object
    private UpdateHistory updateHistory;
    // The selector which will be used to listen to all incoming messages
    private Selector selector;
    
    /**
     * Constructs a Simple Router object, with the immutable neighbor list provided
     *
     * @param neighbors the neighbors of this router
     *
     * @throws IllegalArgumentException if there are no neighbors
     * @throws IOException if a Unix Domain Socket cannot be made
     */
    public SimpleRouter(List<Neighbor> neighbors) throws
            IllegalArgumentException,
            IOException {
        // Ensure that there is at least one neighbor
        if (neighbors.size() == 0) {
            throw new IllegalArgumentException("The router must have at least one neighbor.");
        }
        // Use the given neighbor list as the neighbors of the router
        this.neighbors = neighbors;
        // Initialize an empty forwarding table
        this.forwardingTable = new SimpleTable();
        // Initialize an empty update history
        this.updateHistory = new SimpleHistory();
        
        // Attempt to open an I/O selector
        this.selector = Selector.open();
        
        // Iterate over all the neighbors of this router
        for (Neighbor neighbor : neighbors) {
            
            // Open a new channel, and connect it to the neighbor's address, ported in to a Unix Domain Socket address
            SocketChannel channel = SocketChannel.open(
                    new AFUNIXSocketAddress(new File(
                            Router.byteToString(
                                    neighbor.getAddress()))));
            
            // Disable blocking, so that all neighbors can be queried at once for communications
            channel.configureBlocking(false);
            
            // Register the channel with the selector, enabling the read and write operations,
            // and attach the current neighbor
            SelectionKey key = channel.register(this.selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, neighbor);
        }
    }
    
    /**
     * Beings the router's functioning, waiting for incoming messages on it's ports and responding as necessary to them
     */
    public void start() {
        while (true) {
            Iterator<SelectionKey> selectionKeys = this.selector.selectedKeys().iterator();
            while (selectionKeys.hasNext()) {
                SelectionKey key = selectionKeys.next();
                ((Neighbor) key.attachment()).getSocketController().read();
            }
        }
    }
}

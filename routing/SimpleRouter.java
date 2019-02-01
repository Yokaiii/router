package routing;

import history.*;
import neighbor.*;

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
     */
    public SimpleRouter(List<Neighbor> neighbors) throws IllegalArgumentException {
        // Ensure that there is at least one neighbor
        if (neighbors.size() == 0) {
            throw new IllegalArgumentException("The router must have at least one neighbor.");
        }
        this.neighbors = neighbors;
        
        this.updateHistory = new SimpleHistory();
    }
    
    /**
     * Beings the router's functioning, waiting for incoming messages on it's ports and responding as necessary to them
     */
    public void start() {
    
    }
}

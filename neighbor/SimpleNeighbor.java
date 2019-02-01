package neighbor;

/**
 * An object implementation of Neighbor, which will simply store the values that were provided upon construction
 */
public class SimpleNeighbor implements Neighbor {
    
    // The 4-byte IP address
    private byte[] address;
    // This neighbor's relation to this program's router
    private NeighborRelation relation;
    // The Socket Controller for this neighbor, controlling I/O operations
    private SocketController connection;
    
    /**
     * Constructs a Simple Neighbor, with the host's network information and a socket to perform I/O operations
     *
     * @param address the IP address of the neighbor, in a 4-byte array
     * @param relation the relation of this neighbor to this program's router
     * @param connection the socket controller used to read and write to this neighbor
     *
     * @throws IllegalArgumentException if any of the parameters are invalid
     */
    public SimpleNeighbor(byte[] address, NeighborRelation relation, SocketController connection)
            throws IllegalArgumentException {
        if (address.length != 4) {
            throw new IllegalArgumentException("Cannot create a neighbor without a 4-byte IP address.");
        }
        
        this.address = address;
        this.relation = relation;
        this.connection = connection;
    }
    
    @Override
    public NeighborRelation getRelation() {
        return this.relation;
    }
    
    @Override
    public byte[] getAddress() {
        return this.address;
    }
    
    @Override
    public SocketController getSocketController() {
        return this.connection;
    }
}

package neighbor;

/**
 * An interface to encapsulate a neighboring router to the one in this program
 */
public interface Neighbor {
    
    /**
     * Getter for the IP address of this router
     *
     * @return this router's IP address
     */
    byte[] getAddress();
    
    /**
     * Getter for the relation between our router and this router
     *
     * @return this router's relation to ours
     */
    NeighborRelation getRelation();
    
    /**
     * Getter for the Socket Controller that controls I/O operations to this neighbor
     *
     * @return this neighbor's Socket Controller
     */
    SocketController getSocketController();
}

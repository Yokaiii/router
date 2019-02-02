package neighbor;

/**
 * An interface encapsulating the socket that will perform all I/O operations for this program
 */
public interface SocketController {
    
    /**
     * Getter for the next String from this socket
     *
     * @return the next String received on this socket
     */
    String read();
    
    /**
     * Writes the provided message to the socket
     *
     * @param message the message to write
     */
    void write(String message);
}

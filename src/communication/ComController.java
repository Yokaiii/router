package communication;

/**
 * Implements a means of controlling communications
 */
public interface ComController {

    /**
     * Identifies the message and reacts accordingly, then provides a response message
     * @param message the message that was received
     * @return the message to send
     * @throws IllegalArgumentException if the message is of a corrupted format
     */
    String messageReceived(String message) throws IllegalArgumentException;

    /** Need strictly for the main method to determine if the server is send a FIND or BYE method
     * @return String "FIND" or "BYE"
     */
    String getType(String message);
}


package message;

import routing.*;

/**
 * A class to encapsulate a route update message
 */
public class RouteUpdateMessage extends Message {
    
    // The network information that is being updated
    private ForwardingEntry update;
    
    /**
     * Constructs a message detailing the route update
     *
     * @param srcIP the source IP, in an array of bytes
     * @param dstIP the destination IP, in an array of bytes
     * @param type  the type of message
     * @param update the network information to be updated
     *
     * @throws IllegalArgumentException if any of the fields are invalid
     */
    public RouteUpdateMessage(byte[] srcIP, byte[] dstIP, Type type, ForwardingEntry update) throws
            IllegalArgumentException {
        super(srcIP, dstIP, type);
        if (!type.equals(Type.update)) {
            throw new IllegalArgumentException("Cannot create a route update message of a non-update type.");
        }
        this.update = update;
    }
    
    /**
     * Getter for the forwarding entry update of this message, containing the network information
     *
     * @return the forwarding entry
     */
    public ForwardingEntry getUpdate() {
        return this.update;
    }
}

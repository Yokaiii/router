package message;

import routing.*;

/**
 * A class to encapsulate a table message
 */
public class TableMessage extends Message {
    
    // The forwarding table that is being used to respond to the dump request
    private ForwardingTable table;
    
    /**
     * Constructs a message, which is a response to the dump message
     *
     * @param srcIP the source IP, in an array of bytes
     * @param dstIP the destination IP, in an array of bytes
     * @param type  the type of message
     * @param table the forwarding table to respond to the dump message with
     *
     * @throws IllegalArgumentException if any of the fields are invalid
     */
    public TableMessage(byte[] srcIP, byte[] dstIP, Type type, ForwardingTable table) throws
            IllegalArgumentException {
        super(srcIP, dstIP, type);
        if (!type.equals(Type.table)) {
            throw new IllegalArgumentException("Cannot create a table message of a non-table type.");
        }
        this.table = table;
    }
}

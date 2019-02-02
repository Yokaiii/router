package message;

import jdk.nashorn.api.scripting.*;

/**
 * An abstract class to contain the source, destination, and type of message
 */
public abstract class Message {
    
    // The fields that this message contains
    private Type type;
    private byte[] srcIP;
    private byte[] dstIP;
    
    /**
     * Constructs a message, with only the most basic fields
     *
     * @param srcIP the source IP, in an array of bytes
     * @param dstIP the destination IP, in an array of bytes
     * @param type the type of message
     *
     * @throws IllegalArgumentException if any of the fields are invalid
     */
    public Message(byte[] srcIP, byte[] dstIP, Type type) throws IllegalArgumentException {
        if (srcIP.length != 4 || dstIP.length != 4) {
            throw new IllegalArgumentException("An IP address must contain four bytes.");
        }
        this.srcIP = srcIP;
        this.dstIP = dstIP;
        this.type = type;
    }
    
    /**
     * Getter for the source IP address of this message
     *
     * @return this message's source IP
     */
    public byte[] getSource() {
        return this.srcIP;
    }
    
    /**
     * Getter for the destination IP address of this message
     *
     * @return the message's destination IP
     */
    public byte[] getDest() {
        return this.dstIP;
    }
    
    /**
     * Getter for the type of message that this is
     *
     * @return the message type
     */
    public Type getType() {
        return this.type;
    }
    
    /**
     * Converts the message in to a JSON format, to be sent to other routers
     *
     * @return the JSON representation of this message
     */
    abstract JSObject getJSON();
}

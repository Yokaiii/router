package message;

import jdk.nashorn.api.scripting.JSObject;

/**
 * A class to encapsulate a no route message
 */
public class NoRouteMessage extends Message {
    
    /**
     * Constructs a message, which is a response to the router's inability to locate a path to the destination
     *
     * @param srcIP the source IP, in an array of bytes
     * @param dstIP the destination IP, in an array of bytes
     * @param type  the type of message
     *
     * @throws IllegalArgumentException if any of the fields are invalid
     */
    public NoRouteMessage(byte[] srcIP, byte[] dstIP, Type type) throws
            IllegalArgumentException {
        super(srcIP, dstIP, type);
        if (!type.equals(Type.noRoute)) {
            throw new IllegalArgumentException("Cannot create a no route message of a non-noRoute type.");
        }
    }

    @Override
    JSObject getJSON() {
        return null;
    }
}

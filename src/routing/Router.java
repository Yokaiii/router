package routing;

/**
 * Encapsulates the primary router object, which will make most routing decisions
 */
public interface Router {
    
    /**
     * Starts the router's functions, once it has been initialized
     */
    void start();
    
    /**
     * Static method to convert the given 4-byte address to a String representation
     *
     * @param bytes the byte array representing an IP address
     *
     * @return the base-10 String representation of the address
     */
    static String byteToString(byte[] bytes) {
        return new StringBuilder()
                        .append(bytes[0] & 0xFF)
                        .append(".")
                        .append(bytes[1] & 0xFF)
                        .append(".")
                        .append(bytes[2] & 0xFF)
                        .append(".")
                        .append(bytes[3] & 0xFF)
                        .toString();
    }
}

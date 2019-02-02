package routing;

import neighbor.*;

/**
 * An implementation of a Forwarding Entry, which is immutable and simply maintains its fields
 */
public class SimpleEntry implements ForwardingEntry {
    
    // The network prefix of this entry
    private byte[] networkPrefix;
    // The CIDR netmask of this entry
    private byte[] netmask;
    // The localpref, or path cost, of this entry
    private int localpref;
    // True if this entry was created by a local administrator
    private boolean selfOrigin;
    // The list of autonomous systems along this path
    private int[] asPath;
    // The relationship of this network entry to the LAN in this program
    private Origin origin;
    // The neighbor that is located on this port
    private Neighbor port;
    
    /**
     * Constructs a simple entry for a forwarding table
     *
     * @param networkPrefix the prefix of this network
     * @param netmask the CIDR netmask of this network
     * @param localpref the path cost to reach this network
     * @param selfOrigin true if created by a local administrator
     * @param asPath the list of AS's along this path
     * @param origin the relation of this LAN to the LAN in this program
     * @param port the neighbor located at the port for this entry
     *
     * @throws IllegalArgumentException if any of the arguments are invalid
     */
    public SimpleEntry(byte[] networkPrefix, byte[] netmask, int localpref, boolean selfOrigin, int[] asPath,
                       Origin origin, Neighbor port) throws IllegalArgumentException {
        
        if (networkPrefix.length != 4 || netmask.length != 4) {
            throw new IllegalArgumentException(
                    "Cannot create a forwarding table entry without a 4-byte prefix, and 4-byte CIDR netmask."
            );
        }
        if (localpref < 0) {
            throw new IllegalArgumentException("Cannot give a negative preference to this entry.");
        }
        if (asPath.length == 0) {
            throw new IllegalArgumentException("Cannot create an entry with 0 hops.");
        }
        
        this.networkPrefix = networkPrefix;
        this.netmask = netmask;
        this.localpref = localpref;
        this.selfOrigin = selfOrigin;
        this.asPath = asPath;
        this.origin = origin;
        this.port = port;
    }
    
    @Override
    public byte[] getNetworkPrefix() {
        return this.networkPrefix;
    }
    
    @Override
    public byte[] getNetmask() {
        return this.netmask;
    }
    
    @Override
    public int getLocalpref() {
        return this.localpref;
    }
    
    @Override
    public boolean getSelfOrigin() {
        return this.selfOrigin;
    }
    
    @Override
    public int[] getASPath() {
        return this.asPath;
    }
    
    @Override
    public Origin getOrigin() {
        return this.origin;
    }
    
    @Override
    public Neighbor getPort() {
        return this.port;
    }
    
    @Override
    public String dump() {
        return null;
    }
}

package routing;

import jdk.nashorn.api.scripting.*;
import neighbor.*;

/**
 * An interface to encapsulate a single entry in the forwarding table
 */
public interface ForwardingEntry {
    
    /**
     * Getter for the network prefix of this entry
     *
     * @return the array of 4 bytes composing the network prefix
     */
    byte[] getNetworkPrefix();
    
    /**
     * Getter for the netmask of this entry
     *
     * @return the array of 4 bytes composing this netmask
     */
    byte[] getNetmask();
    
    /**
     * Getter for the localpref, or path cost, of this entry
     *
     * @return the localpref of this forwarding path
     */
    int getLocalpref();
    
    /**
     * Getter for the self origin field, whether this entry was added by the local administrator
     *
     * @return the self origin field
     */
    boolean getSelfOrigin();
    
    /**
     * Getter for the list of Autonomous Systems that the packets along this route will traverse
     *
     * @return the list of AS's in this path
     */
    int[] getASPath();
    
    /**
     * Getter for the router type that this packet originated from
     *
     * @return the router type origin
     */
    Origin getOrigin();
    
    /**
     * Getter for the neighbor that packets on this path will be forwarded to
     *
     * @return the neighbor on this port
     */
    Neighbor getPort();
    
    /**
     * Creates a JSON representation of this entry, to be examined for correctness on a dump message
     *
     * @return the JSON representation of this entry
     */
    JSObject dump();
}

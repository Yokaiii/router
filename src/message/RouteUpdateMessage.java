package message;

import jdk.nashorn.api.scripting.*;
import org.json.*;
import routing.*;
import sun.security.x509.*;

import java.io.*;

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
    
    @Override
    JSObject getJSON() {
        JSONObject json = new JSONObject();
        
        IPAddressName ipsrc  = null;
        IPAddressName ipdest = null;
        IPAddressName msgntw = null;
        IPAddressName msgntm = null;
        
        try {
            ipsrc = new IPAddressName(getSource());
            ipdest = new IPAddressName(getDest());
            msgntw = new IPAddressName(update.getNetworkPrefix());
            msgntm = new IPAddressName(update.getNetmask());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JSONObject msgcontent = new JSONObject();
        msgcontent.put("network", msgntw.toString());
        msgcontent.put("netmask", msgntm.toString());
        msgcontent.put("localpref", update.getLocalpref());
        msgcontent.put("selfOrigin", update.getSelfOrigin());
        msgcontent.put("ASPath", update.getASPath());
        msgcontent.put("origin", update.getOrigin());
        
        
        json.put("src", ipsrc.toString());
        json.put("dst", ipdest.toString());
        json.put("type", getType().toString());
        json.put("msg", msgcontent);
        
        return (JSObject) json;
    }
}

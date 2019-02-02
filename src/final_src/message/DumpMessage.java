package message;

import jdk.nashorn.api.scripting.*;
import org.json.*;
import sun.security.x509.*;

import java.io.*;

/**
 * A class to encapsulate a dump message
 */
public class DumpMessage extends Message {
    
    /**
     * Constructs a message, which instructs the router to send a copy of its forwarding table
     *
     * @param srcIP the source IP, in an array of bytes
     * @param dstIP the destination IP, in an array of bytes
     * @param type  the type of message
     *
     * @throws IllegalArgumentException if any of the fields are invalid
     */
    public DumpMessage(byte[] srcIP, byte[] dstIP, Type type) throws
            IllegalArgumentException {
        super(srcIP, dstIP, type);
        if (!type.equals(Type.dump)) {
            throw new IllegalArgumentException("Cannot create a dump message of a non-dump type.");
        }
    }
    
    @Override
    public JSObject getJSON() {
        JSONObject    json   = new JSONObject();
        IPAddressName ipsrc  = null;
        IPAddressName ipdest = null;
        
        try {
            ipsrc = new IPAddressName(getSource());
            ipdest = new IPAddressName(getDest());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JSONObject msgcontent = new JSONObject();
        
        json.put("src", ipsrc.toString());
        json.put("dst", ipdest.toString());
        json.put("type", getType().toString());
        json.put("msg", msgcontent);
        
        return (JSObject) json;
    }
}

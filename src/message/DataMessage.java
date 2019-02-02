package message;

import jdk.nashorn.api.scripting.JSObject;
import org.json.JSONObject;
import sun.security.x509.IPAddressName;

import java.io.IOException;

/**
 * A class to encapsulate a data message
 */
public class DataMessage extends Message {
    
    // The payload of this message
    private String data;
    
    /**
     * Constructs a message, with a string data field
     *
     * @param srcIP the source IP, in an array of bytes
     * @param dstIP the destination IP, in an array of bytes
     * @param type  the type of message
     * @param data the data payload of this message
     *
     * @throws IllegalArgumentException if any of the fields are invalid
     */
    public DataMessage(byte[] srcIP, byte[] dstIP, Type type, String data) throws
            IllegalArgumentException {
        super(srcIP, dstIP, type);
        if (!type.equals(Type.data)) {
            throw new IllegalArgumentException("Cannot create a data message of a non-data type.");
        }
        this.data = data;
    }
    
    /**
     * Getter for the data payload of this message
     *
     * @return the data string
     */
    public String getData() {
        return this.data;
    }

    @Override
    JSObject getJSON() {
        JSONObject json = new JSONObject();

        IPAddressName ipsrc = null;
        IPAddressName ipdest = null;

        try {
            ipsrc = new IPAddressName(getSource());
            ipdest = new IPAddressName(getDest());
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject msgcontent = new JSONObject();
        msgcontent.put("data", this.data);

        json.put("src", ipsrc.toString());
        json.put("dst", ipdest.toString());
        json.put("type", getType().toString());
        json.put("msg", msgcontent);

        return (JSObject) json;

    }
}

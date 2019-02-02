package routing;

import org.json.JSONArray;
import org.json.JSONObject;
import sun.security.x509.IPAddressName;

import java.io.IOException;
import java.util.*;

/**
 * A simple class to maintain the forwarding table of a router
 */
public class SimpleTable implements ForwardingTable {
    
    // A list of the entries in this table
    List<ForwardingEntry> entries;
    
    /**
     * Constructs a new Forwarding Table, and initializes the entries list
     */
    public SimpleTable() {
        this.entries = new ArrayList<>();
    }
    
    @Override
    public void coalesce() {
    for (ForwardingEntry entry1 : this.entries) {
        for (ForwardingEntry entry2 : this.entries) {
            // Skip the coalesce if these are the same entry
            if (entry1.equals(entry2)) {
                continue;
            }
            
        }
    }
    }
    
    @Override
    public void addEntry(ForwardingEntry entry) {
        this.entries.add(entry);
        this.coalesce();
    }
    
    @Override
    public List<ForwardingEntry> lookupRoutes(byte[] destination) {
        return null;
    }
    
    @Override
    public JSONArray dump() {

        JSONObject dump = new JSONObject();
        JSONArray array = new JSONArray();


        for (ForwardingEntry fe : entries) {
            JSONObject    json   = new JSONObject();
            IPAddressName network  = null;
            IPAddressName netmask = null;

            try {
                network = new IPAddressName(fe.getNetworkPrefix());
                netmask = new IPAddressName(fe.getNetmask());
            } catch (IOException e) {
                e.printStackTrace();
            }

            json.put("network", network.toString());
            json.put("netmask", netmask.toString());
            json.put("peer", fe.getPort());

            array.put(json);

        }

        return array;
    }

}

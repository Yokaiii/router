package routing;

import jdk.nashorn.api.scripting.*;
import org.json.*;
import sun.security.x509.*;

import java.io.*;
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
        List<ForwardingEntry> possibilities = new ArrayList<>();
        for (ForwardingEntry entry : this.entries) {
            for (int i = 0; i < 4; i++) {
                if ((entry.getNetmask()[i] & destination[i]) != entry.getNetworkPrefix()[i]) {
                    break;
                }
            }
            possibilities.add(entry);
        }
        return possibilities;
    }
    
    @Override
    public JSObject dump() {
        JSONArray  array = new JSONArray();
        JSONObject dump  = new JSONObject();
    
        for (ForwardingEntry fe : entries) {
        
            JSONObject    json    = new JSONObject();
            IPAddressName network = null;
            IPAddressName netmask = null;
        
            try {
                network = new IPAddressName(fe.getNetworkPrefix());
                netmask = new IPAddressName(fe.getNetmask());
            } catch (IOException e) {
                e.printStackTrace();
            }
        
            json.put("network", network.toString());
            json.put("netmask", netmask.toString());
        
            json.put("peer", fe.getPort().getRelation());
        
            array.put(json);
        }
    
        dump.put("msg", array);
    
        return (JSObject) dump;
    }
}

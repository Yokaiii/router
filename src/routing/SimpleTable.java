package routing;

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
    public String dump() {
        return null;
    }
}

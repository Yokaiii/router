package routing;

import jdk.nashorn.api.scripting.*;

import java.util.*;

/**
 * An interface to encapsulate the list of routes in a router's forwarding table
 */
public interface ForwardingTable {
    
    /**
     * Aggregates routes in the forwarding table wherever possible
     */
    void coalesce();
    
    /**
     * Adds the provided entry to the forwarding table
     *
     * @param entry the entry to add to the table
     */
    void addEntry(ForwardingEntry entry);
    
    /**
     * Searches for any possible routes that will lead to the destination
     *
     * @param destination the IP address to search for routes to
     *
     * @return the list of all routes that will lead to the destination IP
     */
    List<ForwardingEntry> lookupRoutes(byte[] destination);
    
    /**
     * Exports the table to a JSON, in order to be exported in a dump command
     *
     * @return the table in a JSON format
     */
    JSObject dump();
}

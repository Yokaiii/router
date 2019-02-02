package init;

import neighbor.*;
import routing.*;

import java.io.*;
import java.util.*;

/**
 * A simple implementation of an argument initializer
 */
public class SimpleInitializer implements ArgumentInitializer {
    
    @Override
    public Router parseArguments(String[] args) throws
            IllegalArgumentException {
        // Ensure that there is at least one neighbor
        if (args.length < 1) {
            throw new IllegalArgumentException("Cannot create a router with no neighbors.");
        }
        
        // Initialize a list to store the neighbors passed as arguments
        List<Neighbor> neighbors = new ArrayList<>();
        
        // Iterate over the String argument list
        for (String arg : args) {
            // Extract the IP address field (preceding the '-') and split it at every '.'
            String[] address = arg.substring(0, arg.indexOf("-")).split(".");
            // Address must be four bytes
            if (address.length != 4) {
                throw new IllegalArgumentException("Cannot create a neighbor with a non four-byte IP address.");
            }
            byte[] ip = new byte[4];
            // Iterate over every String and convert it to a byte
            for (int i = 0; i < 4; i++) {
                ip[i] = Byte.parseByte(address[i]);
            }
            
            // Extract the Neighbor Relation field
            NeighborRelation relation = NeighborRelation.parseString(arg.substring(arg.indexOf("-") + 1));
            
            try {
                neighbors.add(
                        new SimpleNeighbor(ip, relation, new SimpleController(arg.substring(0, arg.indexOf("-")))));
            } catch (IOException e) {
                throw new IllegalArgumentException("Could not locate the address specified.");
            }
        }
        try {
            return new SimpleRouter(neighbors);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

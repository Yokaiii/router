package init;

import routing.*;

/**
 * An interface to encapsulate the parsing of command line input, and constructing a Router as specified
 */
public interface ArgumentInitializer {
    
    /**
     * Parses the array of strings, constructing a as specified router
     *
     * @param args the command line input
     *
     * @return the router specified
     *
     * @throws IllegalArgumentException if the arguments are invalid
     */
    Router parseArguments(String[] args) throws IllegalArgumentException;
}

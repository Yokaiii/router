package history;

import message.*;

import java.util.*;

/**
 * A simple implementation of an Update History object
 */
public class SimpleHistory implements UpdateHistory {
    
    // The list of all route update messages received
    List<RouteUpdateMessage> history;
    
    /**
     * Constructs a new Simple History object, and initializes its fields
     */
    public SimpleHistory() {
        this.history = new ArrayList<>();
    }
    
    @Override
    public void update(RouteUpdateMessage update) {
        this.history.add(update);
    }
    
    @Override
    public List<RouteUpdateMessage> getUpdates() {
        return this.history;
    }
}

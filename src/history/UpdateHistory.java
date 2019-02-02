package history;

import message.*;

import java.util.*;

/**
 * An interface to encapsulate the responsibility of maintaining a copy of all update messages
 */
public interface UpdateHistory {
    
    /**
     * Appends the provided update to the history stored in this object
     *
     * @param update the update message to add to the history
     */
    void update(RouteUpdateMessage update);
    
    /**
     * Getter for the list of history that this object is maintaining
     *
     * @return the list of all route update messages seen in this session
     */
    List<RouteUpdateMessage> getUpdates();
}

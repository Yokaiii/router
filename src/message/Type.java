package message;

/**
 * An enum to represent all the valid message types
 */
public enum Type {
    update, revoke, data, noRoute, dump, table;
    
    /**
     * Getter for the String representation of this Type
     *
     * @return the String representation
     */
    public String toString() {
        switch (this) {
            case update: return "update";
            case revoke: return "revoke";
            case data: return "data";
            case noRoute: return "no route";
            case dump: return "dump";
            case table: return "table";
            default: return null;
        }
    }
}

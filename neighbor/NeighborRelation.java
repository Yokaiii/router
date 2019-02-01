package neighbor;

/**
 * An enumeration of all the possible relationships that another router may have with this program's router
 */
public enum NeighborRelation {
    peer, prov, cust;
    
    /**
     * Getter for the String representation of this Neighbor Relation
     *
     * @return the String representation of the relation
     */
    public String toString() {
        switch (this) {
            case peer: return "peer";
            case prov: return "prov";
            case cust: return "cust";
            default: return null;
        }
    }
    
    /**
     * Parses the provided string to a Neighbor Relation
     *
     * @param relation the String representation of a relation
     *
     * @return the Neighbor Relation the String corresponds to, null if none match
     */
    public static NeighborRelation parseString(String relation) {
        switch (relation) {
            case "peer": return peer;
            case "prov": return prov;
            case "cust": return cust;
            default: return null;
        }
    }
}

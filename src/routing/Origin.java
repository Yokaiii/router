package routing;

/**
 * An enumeration of all the possible circumstances that an update message could originate from
 */
public enum Origin {
    IGP, EGP, UNK;
    
    /**
     * Getter for the String representation of this enum
     *
     * @return the String value of the Origin
     */
    public String toString() {
        switch (this) {
            case IGP: return "IGP";
            case EGP: return "EGP";
            case UNK: return "UNK";
            default: return null;
        }
    }
}

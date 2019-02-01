package information;

import java.util.List;

public class ForwardingTable {

    List<ForwardingEntry> entries;

    public ForwardingTable(List<ForwardingEntry> entries) {
        this.entries = entries;
    }
}

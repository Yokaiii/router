package information;

import communication.Neighbor;

public class ForwardingEntry {
    Byte netwPrefix;
    Byte netmask;
    int localpref;
    boolean selfOrigin;
    int[] ASPath;
    Origin origin;
    Neighbor port;

    public ForwardingEntry(Byte netwPrefix, Byte netmask, int localpref, boolean selfOrigin, int[] ASPath,
                           Origin origin, Neighbor port) {

        this.netwPrefix = netwPrefix;
        this.netmask = netmask;
        this.localpref = localpref;
        this.selfOrigin = selfOrigin;
        this.ASPath = ASPath;
        this.origin = origin;
        this.port = port;

    }
}

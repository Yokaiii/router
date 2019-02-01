package information;

import java.util.List;

public class RevocationHistory {

    List<ForwardingEntry> revokes;

    public RevocationHistory(List<ForwardingEntry> revokes) {
        this.revokes = revokes;
    }

}

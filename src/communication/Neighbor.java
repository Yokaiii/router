package communication;

import java.io.IOException;

public class Neighbor implements INeighbor{

    NeighborRelation relation;
    String address;
    SController sockcont;

    public Neighbor(NeighborRelation relation, String address, SController sockcont) throws
            IOException {
        this.relation = relation;
        this.address = address;
        this.sockcont = sockcont;
    }


    @Override
    public NeighborRelation getRelation() {
        return null;
    }

    @Override
    public String getAdress() {
        return null;
    }

    @Override
    public SController getSController() {
        return null;
    }
}

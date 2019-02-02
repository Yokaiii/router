package information;

public class Revocation {
    Byte network;
    Byte netmask;

    public Revocation(Byte network, Byte netmask) {
        this.network = network;
        this.netmask = netmask;
    }

    public Byte getNetwork() {
        return network;
    }

    public Byte getNetmask() {
        return netmask;
    }
}

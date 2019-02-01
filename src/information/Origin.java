package information;

public enum Origin {
    IGP("igp"), EGP("egp"), UNK("unk");

    protected String s;

    Origin(String s){
        this.s=s;
    }

    public String toString() {
        return this.s;
    }
}

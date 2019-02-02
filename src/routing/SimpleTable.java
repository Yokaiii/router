package routing;

import jdk.nashorn.api.scripting.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.security.x509.IPAddressName;

import java.io.IOException;
import java.util.List;

public class SimpleTable implements ForwardingTable {

    private List<ForwardingEntry> enteries;

    public SimpleTable(List<ForwardingEntry> enteries) {
        this.enteries = enteries;
    }

    @Override
    public void coalesce() {

    }

    @Override
    public JSObject dump() {

        JSONArray array = new JSONArray();
        JSONObject dump = new JSONObject();

        for (ForwardingEntry fe : enteries) {

            JSONObject json = new JSONObject();
            IPAddressName network = null;
            IPAddressName netmask = null;

            try {
                network = new IPAddressName(fe.getNetworkPrefix());
                netmask = new IPAddressName(fe.getNetmask());
            } catch (IOException e) {
                e.printStackTrace();
            }

            json.put("network", network.toString());
            json.put("netmask", netmask.toString());

            //IS THIS THE RIGHT ARGS THIS NEEDS?????????????????????????????????
            json.put("peer", fe.getPort());
            //IS THIS THE RIGHT ARGS THIS NEEDS?????????????????????????????????

            array.put(json);
        }

        dump.put("msg", array);

        return (JSObject) dump;
    }

    @Override
    public void addEntry(ForwardingEntry entry) {
        this.enteries.add(entry);

    }

    @Override
    public List<ForwardingEntry> lookupRoutes(byte[] destination) {
        return null;
    }
}

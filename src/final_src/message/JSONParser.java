package message;

import org.json.*;
import routing.*;

import java.util.*;

/**
 * An object to parse JSON Strings in to a usable message
 */
public class JSONParser {
    
    public static Message parseJSON(String json) {
        JSONObject obj = new JSONObject(new JSONTokener(json));
        String[] srcIP = ((String) obj.get("src")).split(".");
        byte[] src = new byte[4];
        for (int i = 0; i < 4; i++) {
            src[i] = Byte.parseByte(srcIP[i]);
        }
        
        String[] dstIP = ((String) obj.get("dst")).split(".");
        byte[] dst = new byte[4];
        for (int i = 0; i < 4; i++) {
            dst[i] = Byte.parseByte(dstIP[i]);
        }
        
        switch (obj.getString("type")) {
            case "data":
                return new DataMessage(src, dst, Type.data, obj.getString("data"));
            case "dump":
                return new DumpMessage(src, dst, Type.dump);
            case "update":
                String[] prfx = ((String) obj.get("network")).split(".");
                byte[] prefix = new byte[4];
                String[] mask = ((String) obj.get("netmask")).split(".");
                byte[] netmask = new byte[4];
                for (int i = 0; i < 4; i++) {
                    prefix[i] = Byte.parseByte(prfx[i]);
                    netmask[i] = Byte.parseByte(mask[i]);
                }
                ArrayList<Integer> path = new ArrayList<>();
                for (Object o : obj.getJSONArray("ASPath")) {
                    path.add((Integer) o);
                }
                int[] intPath = new int[path.size()];
                for (int i = 0; i < path.size(); i++) {
                    intPath[i] = path.get(i);
                }
                return new RouteUpdateMessage(src, dst, Type.update, new SimpleEntry(prefix, netmask, obj.getInt(
                        "localpref"), obj.getBoolean("selfOrigin"), intPath,
                        obj.getEnum(Origin.class,
                        "origin"), null));
        }
        return null;
    }
}

package message;

import org.json.*;

/**
 * An object to parse JSON Strings in to a usable message
 */
public class JSONParser {
    
    public static Message parseJSON(String json) {
        JSONObject obj = new JSONObject(new JSONTokener(json));
        //byte[] srcIP = ((String) obj.get("src")).split(".");
        return null;
    }
}

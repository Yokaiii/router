package communication;

//import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public class SocketController implements SController {

    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;

    public SocketController(Socket socket, BufferedReader reader, BufferedWriter writer){
        this.socket = socket;
        this.reader = reader;
        this.writer = writer;
    }


    @Override
    public String messageReceived(String message) throws IllegalArgumentException {
        return null;
    }

    @Override
    public String getType(String message) {
        return null;
    }
}

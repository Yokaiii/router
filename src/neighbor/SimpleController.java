package neighbor;

import java.io.*;
import java.net.*;

/**
 * An implementation of Socket Controller, which acts as an intermediary for I/O operations on the socket
 */
public class SimpleController implements SocketController {
    
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    @Override
    public String read() {
        return null;
    }
    
    @Override
    public void write(String message) {
    
    }
}

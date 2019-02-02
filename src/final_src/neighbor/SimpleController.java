package neighbor;

import org.newsclub.net.unix.*;

import java.io.*;

/**
 * An implementation of Socket Controller, which acts as an intermediary for I/O operations on the socket
 */
public class SimpleController implements SocketController {
    
    // The Unix Domain Socket
    private AFUNIXSocket socket;
    // The buffered reader, for accepting input
    private BufferedReader reader;
    // The buffered writer, for producing output
    private BufferedWriter writer;
    
    /**
     * Constructs a new Socket Controller implementation, to handle I/O operations
     *
     * @param address the address of the Unix Domain Socket to connect to
     *
     * @throws IOException if the address is invalid
     */
    public SimpleController(String address) throws IOException {
        // Get the file in the current directory with the name "address"
        File path = new File(address);
        // If there was no file throw an error
        if (!path.exists()) {
            throw new IOException("The provided address does not exist!");
        }
        // Create a new instance of a Unix Socket, and then connect it to the file
        this.socket = AFUNIXSocket.newInstance();
        this.socket.connect(new AFUNIXSocketAddress(path));
        
        // Assign the reader and writer to the input and output streams of the socket, respectively
        this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }
    
    @Override
    public String read() {
        StringBuilder message = new StringBuilder();
        try {
            while (this.reader.ready()) {
                message.append(this.reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message.toString();
    }
    
    @Override
    public void write(String message) {
        try {
            this.writer.write(message, 0, message.length());
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

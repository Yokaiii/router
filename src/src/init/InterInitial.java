package init;

import java.util.ArrayList;

public interface InterInitial {
    /**
      * Parses the associated command line arguments
      * @param args the array of arguments provided with the application call
     * @return an arraylist of an arraylist of arguments
     */
    ArrayList<ArrayList<String>> parseArgs(ArrayList<String> args);

    /**
     * Gets the number of ports for the specific application call
     * @return
     */
     int getNumPorts();
}

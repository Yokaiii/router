package init;

import java.io.IOException;
import java.util.ArrayList;

public class Initial implements InterInitial {

    private ArrayList<String>  args;
    private ArrayList<ArrayList<String>>  exit = new ArrayList<>();

    public int i;

    public Initial(ArrayList<String> args) throws
            IOException {

        this.args = args;
        this.i = 0;
    }


    @Override
    public ArrayList<ArrayList<String>> parseArgs(ArrayList<String> args) {
        for (int j = 1; j < args.size(); j++) {
            i++;
            parseHelp(args.get(j));
        }

        return exit;
    }


    @Override
    public int getNumPorts() {
        return i;
    }

    private void parseHelp(String s) {
        ArrayList<String> help = new ArrayList<>();

        String[] ss = s.split("-");

        for (String w : ss) {
            help.add(w);
        }

        help.add(String.valueOf(i));

        exit.add(help);
    }
}

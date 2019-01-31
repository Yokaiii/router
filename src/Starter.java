import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import init.Initial;

//./router 1.2.3.2-cust 192.168.0.2-peer 67.32.9.2-prov

//./router <ip.add.re.ss-[peer,prov,cust]> [ip.add.re.ss-[peer,prov,cust]] ...[ip.add.re.ss-[peer,prov,cust]]

public class Starter {

    public static void main(String[] args) throws IOException {

        ArrayList<String> inFile = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        String init = sc.nextLine();

        String[] arr = init.split(" ");

        for ( String ss : arr) {
            inFile.add(ss);
        }

        Initial i = new Initial(inFile);
        ArrayList<ArrayList<String>> g = i.parseArgs(inFile);


    }
}

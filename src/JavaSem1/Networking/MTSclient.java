package Networking;

// java MTSclient -host spiegel -port 50405
import java.net.*;
import java.io.*;
import java.util.*;
public class MTSclient {

    String hostName = "localhost";
    int    port = 4242;

    private void printMessage()	{
        System.out.println("-h		---->	help");
        System.out.println("[-host 		hostName]");
        System.out.println("[-port 		port]");
    }

    /**
     * Parse the commandlind arguments and sets variables.
     */
    public void parseArgs(String args[]) {

        for (int i = 0; i < args.length; i ++) {
            if (args[i].equals("-h"))
                printMessage();
            else if (args[i].equals("-host"))
                hostName = args[++i];
            else if (args[i].equals("-port"))
                port = new Integer(args[++i]).intValue();
        }
    }

    public void doTheJob()	{
        try {
            Socket socket = new Socket(hostName, port);

            BufferedReader din = new BufferedReader (
                    new InputStreamReader (socket.getInputStream()));
            String newPort = din.readLine ();
            System.out.println ("Use from now in port: " + newPort);
            socket.close();
            din.close();
            socket = new Socket(hostName, new Integer(newPort).intValue());
            din = new BufferedReader ( new InputStreamReader (socket.getInputStream()));
            System.out.println("got: " + din.readLine () );
        } catch (Exception e) {
            System.out.println (e);
        }
    }

    public static void main(String argv[]) {
        MTSclient aMTSclient = new MTSclient();
        aMTSclient.parseArgs(argv);
        aMTSclient.doTheJob();

    }
}

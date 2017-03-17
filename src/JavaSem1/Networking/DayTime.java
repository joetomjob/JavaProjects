package Networking;
import java.net.*;
import java.io.*;
import java.util.*;
public class DayTime {

    String hostName = "localhost";
    int    port = 5918;

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
            System.out.println("host: " +  hostName );
            System.out.println("port: " +  port );
            Socket sock = new Socket(hostName, port);

            BufferedReader din = new BufferedReader (
                    new InputStreamReader (sock.getInputStream()));
            String rTime = din.readLine ();
            System.out.println (rTime);
            sock.close();
        } catch (Exception e) {
            System.out.println (e);
        }
    }

    public static void main(String argv[]) {
        DayTime aDayTime = new DayTime();
        aDayTime.parseArgs(argv);
        aDayTime.doTheJob();

    }
}

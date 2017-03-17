package Networking;

import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class Url_Read {

    public static void readFromUrl(String theUrl) {

        URL aUrl = null;
        BufferedReader in = null;
        String line;

        try {
            aUrl = new URL(theUrl);
            System.out.println("getPort() " + aUrl.getPort());
            System.out.println("getHost() " + aUrl.getHost());
            System.out.println("getProtocol() " + aUrl.getProtocol());
            System.out.println("getFile() " + aUrl.getFile());
            System.out.println("getRef() " + aUrl.getRef());

            in = new BufferedReader(
                    new InputStreamReader( aUrl.openStream() ) );

            while ( ( line = in.readLine() ) != null ) {
                System.out.println(line.replaceAll("<(.|\n)*?>",""));
//                System.out.println(line);
            }

            in.close();

        } catch (MalformedURLException e) {
            System.err.println("Something is wrong with this " +
                    theUrl +  ".");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: "
                    + theUrl );
            System.exit(1);
        }

    }

    public static void main( String args[] ) {
        String s = "https://cs.rit.edu/~trr/";
        if ( s.length() == 0 )	{
            System.err.println(
                    "Usage: java Url_Read url");
            System.exit(1);
        }

        try {
            readFromUrl(s);

        }
        catch ( NumberFormatException e)	{
            System.out.println(args[0] + " is not a number ;-(");
        }

    }
}
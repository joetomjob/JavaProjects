package Networking;

import java.rmi.*;
import java.math.*;

public class Client {

    public static void doIt(String catServer, String mouseServer, int port) {

        MyServer aCatServer;
        MyServer aMouseServer;
        Point    aPoint = new Point(4, 2 );

        System.out.println("In Client: cat   is on: " + catServer );
        System.out.println("In Client: mouse is on: " + mouseServer );
        System.out.println("In Client: port     is: " + port );
        try {
            aCatServer = (MyServer)Naming.lookup("rmi://" +
                    catServer + ":" + port + "/CatServer");

            aMouseServer = (MyServer)Naming.lookup("rmi://" +
                    mouseServer + ":" + port + "/MouseServer");


// -------------- Cat --------------------
            System.out.println("In Client: aCatServer.movePoint(aPoint): " +
                    (aPoint = aCatServer.movePoint(aPoint)).toString() );
            System.out.println("In Client: aCatServer.movePoint(aPoint): " +
                    aCatServer.movePoint(aPoint).toString() );
            System.out.println("In Client: aCatServer.movePoint(aPoint): " +
                    aCatServer.movePoint(aPoint).toString() );

// -------------- Mouse --------------------

            System.out.println("In Client: aMouseServer.movePoint(aPoint): " +
                    (aPoint = aMouseServer.movePoint(aPoint)).toString() );
            System.out.println("In Client: aMouseServer.movePoint(aPoint): " +
                    aMouseServer.movePoint(aPoint).toString() );
            System.out.println("In Client: aMouseServer.movePoint(aPoint): " +
                    aMouseServer.movePoint(aPoint).toString() );



        } catch (Exception e) {
            System.out.println("Something went wrong: " +
                    e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String args[] ) {
        int    port   = 1099;
        String catServer   = "yps";
        String mouseServer = "yps";

        if ( args.length  >= 1 )
            catServer = args[0];
        if ( args.length  >= 2 )
            mouseServer = args[1];
        if ( args.length  == 3 )
            try {
                port = Integer.parseInt(args[2]);
            }
            catch ( NumberFormatException e )	{
                System.out.println("Hm , port = " +
                        args[2] + " is not valid.");
                System.exit(1);
            }

        if ( args.length  > 3 )	{
            System.out.println("Usage: " +
                    "java Client [CatServer [MouseServer [port]]]");
            System.exit(1);
        }

        doIt(catServer, mouseServer, port);
    }
}
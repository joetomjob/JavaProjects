package Networking;

import java.rmi.Naming;

public class PiClient {

    public static void doIt(String host, String port, int digits) {
        String message = "";
        try {
            Pi_MyServer obj = (Pi_MyServer) Naming.lookup("//" +
                    host + ":" + port + "/PiServer");
            System.out.println(obj.computePi(digits));

        } catch (Exception e) {
            System.out.println("Something went wrong: " +
                    e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String args[] ) {
        int    digits = 10;
        String host   = "yps";
        String port   = "";


        if ( args.length  >= 1 )	{
            try {
                digits = Integer.parseInt(args[0]);
            }
            catch ( NumberFormatException e )	{
                System.out.println("Hm , digits = " + args[0]);
                System.exit(1);
            }

        }
        if ( args.length >= 2 )	{
            host = args[1];
        }

        if ( args.length  == 3 )	{
            try {
                port = args[2];
                Integer.parseInt(port);
            }
            catch ( NumberFormatException e )	{
                System.out.println("Port = " + port + " is not valid.");
                System.exit(1);
            }

        }
        if ( args.length  > 3 )	{
            System.out.println("Usage: java Client [digits [host [port]]]");
            System.exit(1);
        }
        doIt(host, port, digits);
    }
}
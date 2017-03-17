package Networking;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class CatServer extends UnicastRemoteObject implements MyServer
{
    final private int DELTA = 10;
    private int x;
    private int y;
    private Point aPoint;

    public CatServer() throws RemoteException {
        ;
    }


    public Point movePoint(Point aPoint) throws RemoteException {
        System.out.println("\tIN CatServer: movePoint(): "
                + aPoint.toString() );
        return aPoint.move(DELTA, DELTA);
    }
    public int getX() throws RemoteException {
        System.out.println("\tCIN atServer: getX(): " + x );
        return  x;
    }

    public int getY() throws RemoteException {
        System.out.println("\tCIN atServer: getY(): " + y );
        return  x;
    }

    public static void main(String args[])
    {
        int port = 1099;

        // System.setSecurityManager(new RMISecurityManager());

        if ( args.length  == 1 )
            try {
                port = Integer.parseInt(args[0]);
            }
            catch ( NumberFormatException e )	{
                System.out.println("Hm , port = " +
                        args[0] + " is not valid.");
                System.exit(1);
            }

        try {
            CatServer obj = new CatServer();
            System.out.println("\tIN CatServer: " +
                    "rmi://:" + port + "/CatServer");
            Naming.rebind("rmi://:" + port + "/CatServer", obj);
            System.out.println("\tIN CatServer bound in registry");
        } catch (RemoteException  e) {
            System.out.println("CatServer RemoteException ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("CatServer err: "
                    + e.getMessage());
            e.printStackTrace();
        }
    }
}

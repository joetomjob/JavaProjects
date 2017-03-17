package Networking;

public interface MyServer extends java.rmi.Remote {
    Point movePoint(Point aPoint) throws java.rmi.RemoteException;
    int getX()                    throws java.rmi.RemoteException;
    int getY()                    throws java.rmi.RemoteException;
}
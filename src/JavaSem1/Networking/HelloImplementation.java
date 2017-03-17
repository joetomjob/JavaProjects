package Networking;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class HelloImplementation
        extends UnicastRemoteObject
        implements HelloInterface {

    public HelloImplementation() throws RemoteException {
    }

    public String sayHello() throws RemoteException {
        return  "Hello World my Friend!";
    }
}
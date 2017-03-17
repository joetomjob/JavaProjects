package Networking;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer_2 extends UnicastRemoteObject {
    private String name;

    public HelloServer_2(String s) throws RemoteException {
        name = s;
    }

    public String sayHello() throws RemoteException {
        return  "Server2()";
    }

    public static void main(String args[])
    {
        // System.setSecurityManager(new RMISecurityManager());

        try {
            HelloServer_2 obj = new HelloServer_2("hi");

            Registry registry = LocateRegistry.createRegistry(8189);
            registry.rebind("IamAhelloImplementationObject2", obj);
            // Naming.rebind("//129.21.36.56/HelloServer", obj);
            System.out.println("HelloServer bound in registry");
        } catch (Exception e) {
            System.out.println("HelloImpl err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

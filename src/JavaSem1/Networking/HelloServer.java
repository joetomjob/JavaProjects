package Networking;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {

    public static void main(String args[])
    {
        // System.setSecurityManager(new RMISecurityManager());

        try {
            HelloInterface obj = new HelloImplementation();

            Registry registry = LocateRegistry.createRegistry(8188);
            registry.rebind("IamAhelloImplementationObject", obj);
            // Naming.rebind("//129.21.36.56/HelloServer", obj);
            System.out.println("HelloServer bound in registry");
        } catch (Exception e) {
            System.out.println("HelloImpl err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

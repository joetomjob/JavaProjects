package Networking;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloC {
    public static void main(String args[] ) {
        String message = "";
        try {
            Registry registry = LocateRegistry.getRegistry(8188);
            HelloInterface obj = (HelloInterface) registry.lookup("IamAhelloImplementationObject");

            message = obj.sayHello();

            System.out.println(message);

            Registry registry_2 = LocateRegistry.getRegistry(8189);
            HelloInterface obj_2 = (HelloInterface) registry.lookup("IamAhelloImplementationObject2");

            message = obj_2.sayHello();

            System.out.println(message);

        } catch (Exception e) {
            System.out.println("HelloC exception: " +
                    e.getMessage());
            e.printStackTrace();
        }
    }
}
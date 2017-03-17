package RMI;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Interface {

    public Server() {}

    public String sayHello() {
        return "Hello, world!";
    }

    public static void main(String args[]) {

        String host = "localhost";
        try {
            Server obj = new Server();
            Interface stub = (Interface) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);


            Registry registry1 = LocateRegistry.getRegistry(host);
            Interface stub1 = (Interface) registry1.lookup("Hello1");
            String response = stub1.sayHello();
            System.out.println("response: " + response);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
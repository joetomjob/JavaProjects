package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client implements Interface{

    private Client() {}

    public static void main(String[] args) {

        String host = "localhost";
        try {
//            Client obj = new Client();
//            Interface stub1 = (Interface) UnicastRemoteObject.exportObject(obj, 0);
//            Registry registry1 = LocateRegistry.getRegistry();
//            registry1.bind("Hello1", stub1);

            Registry registry = LocateRegistry.getRegistry(host);
            Interface stub = (Interface) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public String sayHello() throws RemoteException {
        return null;
    }
}

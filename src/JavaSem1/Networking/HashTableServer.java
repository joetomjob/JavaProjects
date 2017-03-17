package Networking;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class HashTableServer
        extends UnicastRemoteObject
        implements HashTableInterface {
    private String name;

    public HashTableServer(String s) throws RemoteException {
        System.out.println(
                "\tHashTableServer: HashTableServer(String s)");
        name = s;
    }

    public Hashtable playWithAHashTable(String t)
            throws java.rmi.RemoteException {
        Hashtable aHashTable = new Hashtable();
        aHashTable.put("plusplus  Movie", t);
        System.out.println("\tserver: aHashTable = " +
                aHashTable.toString());
        t = "done";
        return aHashTable;
    }
    public static void main(String args[])
    {
        // System.setSecurityManager(new RMISecurityManager());

        try {
            HashTableServer obj = new HashTableServer("HelloServer");
            Registry registry = LocateRegistry.createRegistry(9219);
            registry.rebind("HelloServer", obj);
            System.out.println("HelloServer bound in registry");
        } catch (Exception e) {
            System.out.println("HashTableServer err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
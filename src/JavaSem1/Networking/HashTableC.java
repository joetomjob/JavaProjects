package Networking;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class HashTableC {
    public static void main(String args[] ) {
        String plusMovie = "Smoke Signals";
        Hashtable aHashTable = new Hashtable();
        aHashTable.put("plusplus  Movie", "Comedian Harmonists");

        System.out.println("Client: aHashTable local = " +
                aHashTable.toString());
        try {

            Registry registry = LocateRegistry.getRegistry(9219);
            HashTableInterface obj =
                    (HashTableInterface)registry.lookup("HelloServer");

            aHashTable = obj.playWithAHashTable(plusMovie);

        } catch (Exception e) {
            System.out.println("HelloApplet exception: " +
                    e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Client: aHashTable remote = " +
                aHashTable.toString());
    }
}
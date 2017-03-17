package Networking;

import java.util.*;

public interface HashTableInterface extends java.rmi.Remote {
    Hashtable playWithAHashTable(String t)
            throws java.rmi.RemoteException;
}
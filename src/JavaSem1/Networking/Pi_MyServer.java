package Networking;

import java.math.*;

public interface Pi_MyServer extends java.rmi.Remote {
    BigDecimal computePi(int digits)
            throws java.rmi.RemoteException;
}
package BattleShipSwing;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BattleShipServerInterface extends Remote{
    void rmiGame(BattleShipClientInterface battleShipClientInterface) throws RemoteException;
    void playTheGame(BattleShipClientInterface battleShipClientInterface, Player playerA, Player playerB, Ocean oceana, Ocean oceanb) throws RemoteException;
    void stopFunction(BattleShipClientInterface battleShipClientInterface, String string) throws RemoteException;
    void stopGame() throws RemoteException;
}


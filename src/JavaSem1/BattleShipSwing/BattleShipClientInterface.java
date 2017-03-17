package BattleShipSwing;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BattleShipClientInterface extends Remote {
    Player rmiGame(int row, int col) throws RemoteException;
    void playTheGame(Player playerA, Player playerB, Ocean oceana, Ocean oceanb) throws RemoteException;
    void stopFunction(String string) throws RemoteException;
    void stopGame() throws RemoteException;
}
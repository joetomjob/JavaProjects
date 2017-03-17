package BattleShipRMI;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

//This class is used to write the function to play the game
public class Player extends Fleet implements Serializable{

    public String player;
    public Ocean o;
    public Ocean spo;
    public char Hit;
    public char Miss;

    public Player() {
    }

    //This function is used to play the game
    public Player(Ocean ocean, String Player, char Hit, char Miss) {
        this.o = ocean;
        this.player = Player;
        this.Hit = Hit;
        this.Miss = Miss;
    }

//This function is used to play the game.

}
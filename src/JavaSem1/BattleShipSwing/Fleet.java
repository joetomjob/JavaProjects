package BattleShipSwing;

import java.io.Serializable;
import java.util.Scanner;

public class Fleet implements Serializable{

    public Ship battleShip;
    public Ship carrierShip;
    public Ship destroyerShip;
    public Ship aircraftShip;

    public Fleet(){
        battleShip = new Ship();
        carrierShip = new Ship();
        destroyerShip = new Ship();
        aircraftShip = new Ship();

        battleShip.orientation = null;
        carrierShip.orientation = null;
        destroyerShip.orientation = null;
        aircraftShip.orientation = null;
    }
}
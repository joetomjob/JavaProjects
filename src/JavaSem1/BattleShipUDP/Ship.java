package BattleShipUDP;

import BattleShip11.View.OutputView;
import BattleShip11.View.Ocean;

public class Ship {
    public char battleShip;
    public char carrierShip;
    public char destroyerShip;
    public char aircraftShip;
    int shipLength;
    int xCoordinate;
    int yCoordinate;
    String orientation;

    public Ship(){
        battleShip = 'B';
        carrierShip = 'S';
        destroyerShip = 'D';
        aircraftShip = 'A';
    }
}
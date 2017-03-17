package BattleShipTCPPrevious;

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
        carrierShip = 'C';
        destroyerShip = 'D';
        aircraftShip = 'A';
    }
}
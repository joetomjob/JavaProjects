package BattleShipTCPPrevious;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Fleet {
    public DataInputStream dataInputStream;
    public DataOutputStream dataOutputStream;
    public Fleet(){}
    public Fleet(DataInputStream dataInputStream, DataOutputStream dataOutputStream)
    {
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }
    //Function used to place all the ships in the ocean
    public Player createTheFleet(Player pl, String player) throws IOException{
        Ship s = new Ship();
        Scanner S = new Scanner(System.in);
        int x, y;
        String xcord, ycord, p;
        InputView input = new InputView();
        OutputView output = new OutputView();

        try {
            label1:
            // Battleship
            //While loop used to prompt the player to input the values again if he gives wrong input
            while (true) {
                try {
                    dataOutputStream.writeUTF("Enter the x coordinate for battle ship for " + player + ": ");
                    dataOutputStream.writeBoolean(false);
                    s.xCoordinate = Integer.parseInt(dataInputStream.readUTF());

                    dataOutputStream.writeUTF("Enter the y coordinate for battle ship for " + player + ": ");
                    dataOutputStream.writeBoolean(false);
                    s.yCoordinate = Integer.parseInt(dataInputStream.readUTF());
                }
                catch (Exception e){
                    dataOutputStream.writeUTF("Enter Integer value");
                    dataOutputStream.writeBoolean(true);
                    continue label1;
                }
                //s.orientation = input.inputTheValue("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                dataOutputStream.writeUTF("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                dataOutputStream.writeBoolean(false);
                s.orientation = dataInputStream.readUTF();
                s.shipLength = 4;

                //checks if the coordinates are within the range
                if (s.xCoordinate >= pl.o.minrow && s.xCoordinate < pl.o.maxrow && s.yCoordinate >= pl.o.mincol && s.yCoordinate < pl.o.maxcol) {
                    char mm = pl.o.oc[s.xCoordinate][s.yCoordinate]; //This is saved to check whether the matrix has changed.
                    pl.spo = CreateShip(pl.o, s.xCoordinate, s.yCoordinate, s.orientation, s.battleShip, s.shipLength);// Create the ship with the parameters provided
                    if (pl.spo.oc[s.xCoordinate][s.yCoordinate] != mm) { // Move forward only if the matrix is changed
                        label2:
                        // carrier Ship
                        //While loop used to prompt the player to input the values again if he gives wrong input
                        while (true) {
                            try {
                                dataOutputStream.writeUTF("Enter the x coordinate for Carrier ship for " + player + ": ");
                                dataOutputStream.writeBoolean(false);
                                s.xCoordinate = Integer.parseInt(dataInputStream.readUTF());

                                dataOutputStream.writeUTF("Enter the y coordinate for Carrier ship for " + player + ": ");
                                dataOutputStream.writeBoolean(false);
                                s.yCoordinate = Integer.parseInt(dataInputStream.readUTF());
                            } catch (Exception e) {
                                dataOutputStream.writeUTF("Enter Integer value");
                                dataOutputStream.writeBoolean(true);
                                continue label2;
                            }
                            dataOutputStream.writeUTF("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                            dataOutputStream.writeBoolean(false);
                            s.orientation = dataInputStream.readUTF();
                            s.shipLength = 3;

                            //checks if the coordinates are within the range
                            if (s.xCoordinate >= pl.o.minrow && s.xCoordinate < pl.o.maxrow && s.yCoordinate >= pl.o.mincol && s.yCoordinate < pl.o.maxcol) {
                                mm = pl.spo.oc[s.xCoordinate][s.yCoordinate];//This is saved to check whether the matrix has changed.

                                pl.spo = CreateShip(pl.o, s.xCoordinate, s.yCoordinate, s.orientation, s.carrierShip, s.shipLength);// Create the ship with the parameters provided

                                if (pl.spo.oc[s.xCoordinate][s.yCoordinate] != mm) {// Move forward only if the matrix is changed
                                    label3:
                                    //While loop used to prompt the player to input the values again if he gives wrong input
                                    while (true) {//Destroyer ship
                                        try {
                                            dataOutputStream.writeUTF("Enter the x coordinate for Destroyer ship for " + player + ": ");
                                            dataOutputStream.writeBoolean(false);
                                            s.xCoordinate = Integer.parseInt(dataInputStream.readUTF());

                                            dataOutputStream.writeUTF("Enter the y coordinate for Destroyer ship for " + player + ": ");
                                            dataOutputStream.writeBoolean(false);
                                            s.yCoordinate = Integer.parseInt(dataInputStream.readUTF());
                                        }
                                        catch (Exception e){
                                            dataOutputStream.writeUTF("Enter Integer value");
                                            dataOutputStream.writeBoolean(true);
                                            continue label3;
                                        }

                                        dataOutputStream.writeUTF("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                                        dataOutputStream.writeBoolean(false);
                                        s.orientation = dataInputStream.readUTF();
                                        s.shipLength = 2;

                                        //checks if the coordinates are within the range
                                        if (s.xCoordinate >= pl.o.minrow && s.xCoordinate < pl.o.maxrow && s.yCoordinate >= pl.o.mincol && s.yCoordinate < pl.o.maxcol) {
                                            mm = pl.spo.oc[s.xCoordinate][s.yCoordinate];//This is saved to check whether the matrix has changed.

                                            pl.spo = CreateShip(pl.o, s.xCoordinate, s.yCoordinate, s.orientation, s.destroyerShip, s.shipLength);// Create the ship with the parameters provided
                                            if (pl.spo.oc[s.xCoordinate][s.yCoordinate] != mm) {// Move forward only if the matrix is changed
                                                label4:
                                                // Aircraft ship
                                                //While loop used to prompt the player to input the values again if he gives wrong input
                                                while (true) {
                                                    try {
                                                        dataOutputStream.writeUTF("Enter the x coordinate for Aircraft ship for " + player + ": ");
                                                        dataOutputStream.writeBoolean(false);
                                                        s.xCoordinate = Integer.parseInt(dataInputStream.readUTF());

                                                        dataOutputStream.writeUTF("Enter the y coordinate for Aircraft ship for " + player + ": ");
                                                        dataOutputStream.writeBoolean(false);
                                                        s.yCoordinate = Integer.parseInt(dataInputStream.readUTF());
                                                    }
                                                    catch (Exception e){
                                                        dataOutputStream.writeUTF("Enter Integer value");
                                                        dataOutputStream.writeBoolean(true);
                                                        continue label4;
                                                    }
                                                    dataOutputStream.writeUTF("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                                                    dataOutputStream.writeBoolean(false);
                                                    s.orientation = dataInputStream.readUTF();
                                                    s.shipLength = 2;

                                                    //checks if the coordinates are within the range
                                                    if (s.xCoordinate >= pl.o.minrow && s.xCoordinate < pl.o.maxrow && s.yCoordinate >= pl.o.mincol && s.yCoordinate  < pl.o.maxcol) {
                                                        mm = pl.spo.oc[s.xCoordinate ][s.yCoordinate ];//This is saved to check whether the matrix has changed.

                                                        pl.spo = CreateShip(pl.o, s.xCoordinate, s.yCoordinate, s.orientation, s.aircraftShip, s.shipLength); // Create the ship with the parameters provided
                                                        if (pl.spo.oc[s.xCoordinate][s.yCoordinate] != mm) {// Move forward only if the matrix is changed
                                                            pl.o = pl.spo;
                                                            break label1;
                                                        } else {
                                                            continue label4;
                                                        }
                                                    } else {
                                                        dataOutputStream.writeUTF("Invalid Input");
                                                        dataOutputStream.writeBoolean(true);
                                                        continue label3;
                                                    }
                                                }
                                            } else {
                                                continue label3;
                                            }
                                        } else {
                                            dataOutputStream.writeUTF("Invalid Input");
                                            dataOutputStream.writeBoolean(true);
                                            continue label3;
                                        }
                                    }
                                } else {
                                    continue label2;
                                }
                            } else {
                                dataOutputStream.writeUTF("Invalid Input");
                                dataOutputStream.writeBoolean(true);
                                continue label2;
                            }
                        }
                    } else {
                        continue label1;
                    }
                } else {
                    dataOutputStream.writeUTF("Invalid Input");
                    dataOutputStream.writeBoolean(true);
                    continue label1;
                }

            }

        } catch (java.util.InputMismatchException e) {
            dataOutputStream.writeUTF("Invalid Input");
            dataOutputStream.writeBoolean(true);
        }
        return pl;
    }

    public Ocean CreateShip(Ocean n, int x, int y, String p, char b, int len) throws IOException{

        OutputView output = new OutputView();
        Ocean dd = n;
        if (p.equals("v")) {
            if (x + (len - 1) < n.maxrow && y < n.maxcol) {
                for (int k = 0; k < len; k++) {
                    if (dd.oc[x + k][y] == '~') {
                        dd.oc[x + k][y] = b;
                    } else {
                        dataOutputStream.writeUTF("You cant put Ship over here. Please enter other value");
                        dataOutputStream.writeBoolean(true);
                        return n;
                    }
                }
            }
        } else if (p.equals("h")) {
            if (x < n.maxrow && y + (len - 1) < n.maxcol) {
                for (int k = 0; k < len; k++) {
                    if (dd.oc[x][y + k] == '~') {
                        dd.oc[x][y + k] = b;
                    } else {
                        dataOutputStream.writeUTF("You cant put Ship over here. Please enter other value");
                        dataOutputStream.writeBoolean(true);
                        return n;
                    }
                }
            }
        } else {
            dataOutputStream.writeUTF("You entered an incorrect orientation");
            dataOutputStream.writeBoolean(true);
            return n;
        }

        return dd;
    }
}
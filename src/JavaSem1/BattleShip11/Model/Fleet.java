package BattleShip11.Model;

import BattleShip11.View.InputView;
import BattleShip11.View.OutputView;
import BattleShip11.View.Ocean;

import java.util.Scanner;

public class Fleet {
    //Function used to place all the ships in the ocean
    public Player createTheFleet(Player pl, String player) {
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
                    xcord = input.inputTheValue("Enter the x coordinate for battle ship for " + player + ": ");
                    s.xCoordinate = Integer.parseInt(xcord);

                    ycord = input.inputTheValue("Enter the y coordinate for battle ship for " + player + ": ");
                    s.yCoordinate = Integer.parseInt(ycord);
                }
                catch (Exception e){
                    output.outputValue("Enter Integer value");
                    continue label1;
                }
                s.orientation = input.inputTheValue("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
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
                                xcord = input.inputTheValue("Enter the x coordinate for Carrier ship for " + player + ": ");
                                s.xCoordinate = Integer.parseInt(xcord);

                                ycord = input.inputTheValue("Enter the y coordinate for Carrier ship for " + player + ": ");
                                s.yCoordinate = Integer.parseInt(ycord);
                            } catch (Exception e) {
                                output.outputValue("Enter Integer value");
                                continue label2;
                            }
                            s.orientation = input.inputTheValue("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
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
                                            xcord = input.inputTheValue("Enter the x coordinate for Destroyer ship for " + player + ": ");
                                            s.xCoordinate = Integer.parseInt(xcord);

                                            ycord = input.inputTheValue("Enter the y coordinate for Destroyer ship for " + player + ": ");
                                            s.yCoordinate = Integer.parseInt(ycord);
                                        }
                                        catch (Exception e){
                                            output.outputValue("Enter Integer value");
                                            continue label3;
                                        }

                                        s.orientation = input.inputTheValue("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
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
                                                        xcord = input.inputTheValue("Enter the x coordinate for Aircraft ship for " + player + ": ");
                                                        s.xCoordinate = Integer.parseInt(xcord);

                                                        ycord = input.inputTheValue("Enter the y coordinate for Aircraft ship for " + player + ": ");
                                                        s.yCoordinate = Integer.parseInt(ycord);
                                                    }
                                                    catch (Exception e){
                                                        output.outputValue("Enter Integer value");
                                                        continue label4;
                                                    }
                                                    s.orientation = input.inputTheValue("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
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
                                                        output.outputValue("Invalid Input");
                                                        continue label3;
                                                    }
                                                }
                                            } else {
                                                continue label3;
                                            }
                                        } else {
                                            output.outputValue("Invalid Input");
                                            continue label3;
                                        }
                                    }
                                } else {
                                    continue label2;
                                }
                            } else {
                                output.outputValue("Invalid Input");
                                continue label2;
                            }
                        }
                    } else {
                        continue label1;
                    }
                } else {
                    output.outputValue("Invalid Input");
                    continue label1;
                }

            }

        } catch (java.util.InputMismatchException e) {
            output.outputValue("Invalid Input");
        }
        return pl;
    }

    public Ocean CreateShip(Ocean n, int x, int y, String p, char b, int len) {

        OutputView output = new OutputView();
        Ocean dd = n;
        if (p.equals("v")) {
            if (x + (len - 1) < n.maxrow && y < n.maxcol) {
                for (int k = 0; k < len; k++) {
                    if (dd.oc[x + k][y] == '~') {
                        dd.oc[x + k][y] = b;
                    } else {
                        output.outputValue("You cant put Ship over here. Please enter other value");
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
                        output.outputValue("You cant put Ship over here. Please enter other value");
                        return n;
                    }
                }
            }
        } else {
            output.outputValue("You entered an incorrect orientation");
            return n;
        }

        return dd;
    }
}
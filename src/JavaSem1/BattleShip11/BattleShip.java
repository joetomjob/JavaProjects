package BattleShip11;

import BattleShip11.Model.*;
import BattleShip11.View.*;

import java.util.Scanner;


//This class is used to create the fleet. All the 4 ships are placed using this class

public class BattleShip {
    public static void main(String[] args) {

        int minrow = 0;
        int mincol = 0;
        int maxrow = 10;
        int maxcol = 10;


        Ocean aOcean = new Ocean(minrow, mincol, maxrow, maxcol);
        Ocean bOcean = new Ocean(minrow, mincol, maxrow, maxcol);

        Player playerA = new Player(aOcean, "player A", 'H', 'm');
        Player playerB = new Player(bOcean, "player B", 'H', 'm');

        Fleet fleetA = new Fleet();
        Fleet fleetB = new Fleet();

        playerA = fleetA.createTheFleet(playerA, playerA.player);
        playerB = fleetB.createTheFleet(playerB, playerB.player);

        aOcean.DisplaytheOcean(playerA.o, playerA.player);
        aOcean.DisplaytheOcean(playerB.o, playerB.player);

        playGameWith(playerA, playerB);

    }
    public static void playGameWith(Player a, Player b) {
        OutputView output = new OutputView();
        Scanner S = new Scanner(System.in);
        //Below objects for ocean is used to display the Hits and misses to the players
        Ocean pla = new Ocean(0, 0, a.o.maxrow, a.o.maxcol);
        Ocean plb = new Ocean(0, 0, b.o.maxrow, b.o.maxcol);

        //While loop used to prompt the user to input the values again until one player wins

        while (true) {
            int countera = 0;
            int counterb = 0;

            int replayHitA = 1;
            int replayHitB = 1;

            int x, y;

            label10:
            while (replayHitA == 1) {

                output.outputValue("Player A : Enter the x coordinate :");
                x = S.nextInt();
                output.outputValue("Player A : Enter the y coordinate :");
                y = S.nextInt();
                if (x < b.o.maxrow && x < b.o.maxcol && x >= b.o.minrow && x >= b.o.mincol) {
                    if (b.o.oc[x][y] == '~') {
                        b.o.oc[x][y] = b.Miss;
                        pla.oc[x][y] = b.Miss;
                        output.outputValue("That was a miss.");
                        replayHitA = 0;
                        //Below for loop used to save the miss
                        pla.DisplaytheOcean(pla, b.player);

                    } else if (b.o.oc[x][y] == b.Miss || b.o.oc[x][y] == b.Hit) {
                        replayHitA = 0;
                        output.outputValue("This coordinates were supplied earlier.");
                    } else {
                        //Below for loop used to save the Hit
                        b.o.oc[x][y] = b.Hit;
                        pla.oc[x][y] = b.Hit;
                        output.outputValue("That was a Hit.");

                        replayHitA = 1; // Set this to one if there is a hit so that the player have one more chace to play

                        pla.DisplaytheOcean(pla, b.player);

                    }
                    //This loop is used to increment the counter. The total number of coordinates used by ships are 10(4+3+2+1)
                    countera = 0;
                    for (int l = 0; l < b.o.maxrow; l++) {
                        for (int m = 0; m < b.o.maxcol; m++) {
                            if (b.o.oc[l][m] == b.Hit) {
                                countera++;
                            }
                        }
                    }
                    //checks if all the ships are down.
                    if (countera == 11) {
                        output.outputValue(a.player + " Wins");
                        System.exit(0);
                    }
                } else {
                    output.outputValue("Invalid Input");
                    continue label10;
                }

            }

            label11:
            while (replayHitB == 1) {

                output.outputValue("Player B : Enter the x coordinate :");
                x = S.nextInt();
                output.outputValue("Player B : Enter the y coordinate :");
                y = S.nextInt();

                if (x < a.o.maxrow && x < a.o.maxcol && x >= a.o.minrow && x >= a.o.mincol) {
                    if (a.o.oc[x][y] == '~') {
                        a.o.oc[x][y] = a.Miss;
                        plb.oc[x][y] = a.Miss;
                        output.outputValue("That was a miss.");
                        replayHitB = 0;
                        //Used to save a miss
                        plb.DisplaytheOcean(plb, a.player);

                    } else if (a.o.oc[x][y] == a.Miss || a.o.oc[x][y] == a.Hit) {
                        replayHitB = 0;
                        output.outputValue("This coordinates were supplied earlier.");
                    } else {
                        //Used to save a hit
                        a.o.oc[x][y] = a.Hit;
                        plb.oc[x][y] = a.Hit;
                        output.outputValue("That was a Hit.");

                        replayHitB = 1;

                        plb.DisplaytheOcean(plb, a.player);

                    }
                    //This loop is used to increment the counter. The total number of coordinates used by ships are 10(4+3+2+1)
                    counterb = 0;
                    for (int l = 0; l < b.o.maxrow; l++) {
                        for (int m = 0; m < b.o.maxcol; m++) {
                            if (a.o.oc[l][m] == a.Hit) {
                                counterb++;
                            }
                        }
                    }
                    //checks whether all ships are down. If all ships of one player are down, the opponent player wins
                    if (counterb == 11) {
                        output.outputValue(b.player + " Wins");
                        System.exit(0);
                    }
                } else {
                    output.outputValue("Invalid Input");
                    continue label11;
                }
            }
        }

    }
}
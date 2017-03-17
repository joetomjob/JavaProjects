package BattleShip4;

import java.util.Scanner;

//This class is used to write the function to play the game
class Player extends Fleet implements Ship{

    String player;
    Ocean o;
    Ocean spo;
    char Hit;
    char Miss;

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
    public void playGameWith(Player b) {
        Scanner S = new Scanner(System.in);
        //Below objects for ocean is used to display the Hits and misses to the players
        Ocean pla = new Ocean(0, 0, this.o.maxrow, this.o.maxcol);
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

                System.out.println("Player A : Enter the x coordinate :");
                x = S.nextInt();
                System.out.println("Player A : Enter the y coordinate :");
                y = S.nextInt();
                if (x < b.o.maxrow && x < b.o.maxcol && x > b.o.minrow && x > b.o.mincol) {
                    if (b.o.oc[x][y] == '~') {
                        b.o.oc[x][y] = b.Miss;
                        pla.oc[x][y] = b.Miss;
                        System.out.println("That was a miss.");
                        replayHitA = 0;
                        //Below for loop used to save the miss
                        for (int i = 0; i < b.o.maxrow; i++) {
                            for (int j = 0; j < b.o.maxcol; j++) {
                                System.out.print(pla.oc[i][j]);
                                System.out.print('\t');
                            }
                            System.out.print('\n');
                        }
                    } else if (b.o.oc[x][y] == b.Miss || b.o.oc[x][y] == b.Hit) {
                        replayHitA = 0;
                        System.out.println("This coordinates were supplied earlier.");
                    } else {
                        //Below for loop used to save the Hit
                        b.o.oc[x][y] = b.Hit;
                        pla.oc[x][y] = b.Hit;
                        System.out.println("That was a Hit.");

                        replayHitA = 1; // Set this to one if there is a hit so that the player have one more chace to play

                        for (int i = 0; i < pla.maxrow; i++) {
                            for (int j = 0; j < pla.maxcol; j++) {
                                System.out.print(pla.oc[i][j]);
                                System.out.print('\t');
                            }
                            System.out.print('\n');
                        }
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
                    if (countera == 10) {
                        System.out.println(this.player + " Wins");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Invalid Input");
                    continue label10;
                }

            }

            label11:
            while (replayHitB == 1) {

                System.out.println("Player B : Enter the x coordinate :");
                x = S.nextInt();
                System.out.println("Player B : Enter the y coordinate :");
                y = S.nextInt();

                if (x < this.o.maxrow && x < this.o.maxcol && x > this.o.minrow && x > this.o.mincol) {
                    if (this.o.oc[x][y] == '~') {
                        this.o.oc[x][y] = this.Miss;
                        plb.oc[x][y] = this.Miss;
                        System.out.println("That was a miss.");
                        replayHitB = 0;
                        //Used to save a miss
                        for (int i = 0; i < plb.maxrow; i++) {
                            for (int j = 0; j < plb.maxcol; j++) {
                                System.out.print(plb.oc[i][j]);
                                System.out.print('\t');
                            }
                            System.out.print('\n');
                        }

                    } else if (this.o.oc[x][y] == this.Miss || this.o.oc[x][y] == this.Hit) {
                        replayHitB = 0;
                        System.out.println("This coordinates were supplied earlier.");
                    } else {
                        //Used to save a hit
                        this.o.oc[x][y] = this.Hit;
                        plb.oc[x][y] = this.Hit;
                        System.out.println("That was a Hit.");

                        replayHitB = 1;

                        for (int i = 0; i < plb.maxrow; i++) {
                            for (int j = 0; j < plb.maxcol; j++) {
                                System.out.print(plb.oc[i][j]);
                                System.out.print('\t');
                            }
                            System.out.print('\n');
                        }

                    }
                    //This loop is used to increment the counter. The total number of coordinates used by ships are 10(4+3+2+1)
                    counterb = 0;
                    for (int l = 0; l < b.o.maxrow; l++) {
                        for (int m = 0; m < b.o.maxcol; m++) {
                            if (this.o.oc[l][m] == this.Hit) {
                                counterb++;
                            }
                        }
                    }
                    //checks whether all ships are down. If all ships of one player are down, the opponent player wins
                    if (counterb == 10) {
                        System.out.println(b.player + " Wins");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Invalid Input");
                    continue label11;
                }
            }
        }

    }

    public void createTheFleet(Player pl, String player) {
        Scanner S = new Scanner(System.in);
        int x, y;
        String p;
        try {
            label1:
            // Battleship
            //While loop used to prompt the player to input the values again if he gives wrong input
            while (true) {
                System.out.println("Enter the x coordinate for battle ship for " + player + ": ");
                x = S.nextInt();
                System.out.println("Enter the y coordinate for battle ship for " + player + ": ");
                y = S.nextInt();
                System.out.println("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                p = S.next();
                //checks if the coordinates are within the range
                if (x >= pl.o.minrow && x < pl.o.maxrow && y >= pl.o.mincol && y < pl.o.maxcol) {
                    char mm = pl.o.oc[x][y]; //This is saved to check whether the matrix has changed.
                    pl.spo = CreateShip(pl.o, x, y, p, 'B', 4);// Create the ship with the parameters provided
                    if (pl.spo.oc[x][y] != mm) { // Move forward only if the matrix is changed
                        label2:
                        // carrier Ship
                        //While loop used to prompt the player to input the values again if he gives wrong input
                        while (true) {
                            System.out.println("Enter the x coordinate for Carrier ship for " + player + ": ");
                            x = S.nextInt();
                            System.out.println("Enter the y coordinate for Carrier ship for " + player + ": ");
                            y = S.nextInt();
                            System.out.println("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                            p = S.next();
                            //checks if the coordinates are within the range
                            if (x >= pl.o.minrow && x < pl.o.maxrow && y >= pl.o.mincol && y < pl.o.maxcol) {
                                mm = pl.spo.oc[x][y];//This is saved to check whether the matrix has changed.

                                pl.spo = CreateShip(pl.o, x, y, p, 'C', 3);// Create the ship with the parameters provided

                                if (pl.spo.oc[x][y] != mm) {// Move forward only if the matrix is changed
                                    label3:
                                    //While loop used to prompt the player to input the values again if he gives wrong input
                                    while (true) {//Destroyer ship
                                        System.out.println("Enter the x coordinate for Destroyer ship for " + player + ": ");
                                        x = S.nextInt();
                                        System.out.println("Enter the y coordinate for Destroyer ship for " + player + ": ");
                                        y = S.nextInt();
                                        System.out.println("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                                        p = S.next();
                                        //checks if the coordinates are within the range
                                        if (x >= pl.o.minrow && x < pl.o.maxrow && y >= pl.o.mincol && y < pl.o.maxcol) {
                                            mm = pl.spo.oc[x][y];//This is saved to check whether the matrix has changed.

                                            pl.spo = CreateShip(pl.o, x, y, p, 'D', 2);// Create the ship with the parameters provided
                                            if (pl.spo.oc[x][y] != mm) {// Move forward only if the matrix is changed
                                                label4:
                                                // Aircraft ship
                                                //While loop used to prompt the player to input the values again if he gives wrong input
                                                while (true) {
                                                    System.out.println("Enter the x coordinate for Aircraft ship for " + player + ": ");
                                                    x = S.nextInt();
                                                    System.out.println("Enter the y coordinate for Aircraft ship for " + player + ": ");
                                                    y = S.nextInt();
                                                    System.out.println("Do you need to place the battle ship horizontal or vertical (Enter v/h): ");
                                                    p = S.next();
                                                    //checks if the coordinates are within the range
                                                    if (x >= pl.o.minrow && x < pl.o.maxrow && y >= pl.o.mincol && y < pl.o.maxcol) {
                                                        mm = pl.spo.oc[x][y];//This is saved to check whether the matrix has changed.

                                                        pl.spo = CreateShip(pl.o, x, y, p, 'A', 1); // Create the ship with the parameters provided
                                                        if (pl.spo.oc[x][y] != mm) {// Move forward only if the matrix is changed
                                                            pl.o = pl.spo;
                                                            break label1;
                                                        } else {
                                                            continue label4;
                                                        }
                                                    } else {
                                                        System.out.println("Invalid Input");
                                                        continue label3;
                                                    }
                                                }
                                            } else {
                                                continue label3;
                                            }
                                        } else {
                                            System.out.println("Invalid Input");
                                            continue label3;
                                        }
                                    }
                                } else {
                                    continue label2;
                                }
                            } else {
                                System.out.println("Invalid Input");
                                continue label2;
                            }
                        }
                    } else {
                        continue label1;
                    }
                } else {
                    System.out.println("Invalid Input");
                    continue label1;
                }

            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid Input");
            return;
        }
    }
    Ocean dd;
    public Ocean CreateShip(Ocean n, int x, int y, String p, char b, int len) {
        dd = n;
        if (p.equals("v")) {
            if (x + (len - 1) < n.maxrow && y < n.maxcol) {
                for (int k = 0; k < len; k++) {
                    if (dd.oc[x + k][y] == '~') {
                        dd.oc[x + k][y] = b;
                    } else {
                        System.out.println("You cant put Ship over here. Please enter other value");
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
                        System.out.println("You cant put Ship over here. Please enter other value");
                        return n;
                    }
                }
            }
        } else {
            System.out.println("You entered an incorrect orientation");
            return n;
        }

        return dd;
    }

}
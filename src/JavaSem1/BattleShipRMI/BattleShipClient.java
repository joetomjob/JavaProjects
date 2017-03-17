package BattleShipRMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class BattleShipClient implements BattleShipClientInterface, Serializable {

    public static BattleShipClientInterface battleStub;

    public static String host = "localhost";
    public static Registry registry;
    public static BattleShipServerInterface serverResponse;

    @Override
    public Player rmiGame() throws RemoteException {
        System.out.println("Data in Old_Client");
        int minrow = 0;
        int mincol = 0;
        int maxrow = 10;
        int maxcol = 10;

        Ocean bOcean = new Ocean(minrow, mincol, maxrow, maxcol);
        Player playerB = new Player(bOcean, "player B", 'H', 'm');
        Fleet fleetB = new Fleet();
        playerB = fleetB.createTheFleet(playerB, playerB.player);
        bOcean.DisplaytheOcean(playerB.o, playerB.player);
        System.out.println(playerB.player + " finished creating the fleet. Handed over to Next player");
        return playerB;
    }

    @Override
    public void stopFunction(String string) throws RemoteException {
        System.out.println(string);
        System.exit(0);
    }

    @Override
    public void playTheGame(Player a, Player b, Ocean oceana, Ocean oceanb) throws RemoteException {
        OutputView output = new OutputView();
        Scanner S = new Scanner(System.in);
        //Below objects for ocean is used to display the Hits and misses to the players

        Ocean pla;
        Ocean plb;
        if (oceana == null && oceanb == null) {
            pla = new Ocean(0, 0, a.o.maxrow, a.o.maxcol);
            plb = new Ocean(0, 0, b.o.maxrow, b.o.maxcol);
        } else {
            pla = oceana;
            plb = oceanb;
        }

        while (true) {

            int counterb = 0;

            int replayHitB = 1;

            String xcord, ycord;
            int x = -1, y = -1;
            label11:
            while (replayHitB == 1) {

                output.outputValue(b.player + " : Enter the x coordinate :");
                xcord = S.next();
                output.outputValue(b.player + " : Enter the y coordinate :");
                ycord = S.next();

                if (xcord.matches("\\d+") && ycord.matches("\\d+")) {
                    x = Integer.parseInt(xcord);
                    y = Integer.parseInt(ycord);
                } else {
                    output.outputValue("Please enter Integer values");
                    continue label11;
                }

                if (x < a.o.maxrow && x < a.o.maxcol && x >= a.o.minrow && x >= a.o.mincol) {
                    if (a.o.oc[x][y] == '~') {
                        a.o.oc[x][y] = a.Miss;
                        plb.oc[x][y] = a.Miss;
                        output.outputValue("That was a miss.");
                        replayHitB = 0;
                        //Used to save a miss
                        plb.DisplaytheOcean(plb, a.player);
                        System.out.println("Handed over to next player");
                        serverResponse.playTheGame(battleStub, a, b, pla, plb);

                    } else if (a.o.oc[x][y] == a.Miss || a.o.oc[x][y] == a.Hit) {
                        replayHitB = 0;
                        output.outputValue("This coordinates were supplied earlier.Handed over to next player");
                        serverResponse.playTheGame(battleStub, a, b, pla, plb);
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
                        serverResponse.stopFunction(battleStub, b.player + " Wins. You Lose");
                        System.exit(0);
                    }
                } else {
                    output.outputValue("Invalid Input");
                    continue label11;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BattleShipClient battleClient = new BattleShipClient();
        battleStub = (BattleShipClientInterface) UnicastRemoteObject.exportObject(battleClient, 0);

        registry = LocateRegistry.getRegistry(8172);
        serverResponse = (BattleShipServerInterface) registry.lookup("BattleShipServerInterface");
        System.out.println("Server starts the game");
        serverResponse.rmiGame(battleStub);

    }
}
package BattleShipRMI;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


//This class is used to create the fleet. All the 4 ships are placed using this class

public class BattleShip implements BattleShipServerInterface, Serializable {

    @Override
    public void stopFunction(BattleShipClientInterface battleShipClientInterface, String string) throws RemoteException {
        System.out.println(string);
        try {
            LocateRegistry.getRegistry().unbind("BattleShipServerInterface");
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return;
        //System.exit(0);
    }

    @Override
    public void rmiGame(BattleShipClientInterface battleShipClientInterface) throws RemoteException {

        int minrow = 0;
        int mincol = 0;
        int maxrow = 10;
        int maxcol = 10;

        Ocean aOcean = new Ocean(minrow, mincol, maxrow, maxcol);
        Player playerA = new Player(aOcean, "player A", 'H', 'm');
        Fleet fleetA = new Fleet();
        playerA = fleetA.createTheFleet(playerA, playerA.player);
        aOcean.DisplaytheOcean(playerA.o, playerA.player);

        System.out.println(playerA.player + " finished creating the fleet. Handed over to Next player");
        Player playerB = battleShipClientInterface.rmiGame();
        playTheGame(battleShipClientInterface, playerA, playerB, null, null);
    }

    @Override
    public void playTheGame(BattleShipClientInterface battleShipClientInterface, Player a, Player b, Ocean oceana, Ocean oceanb) throws RemoteException {
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
            int countera = 0;
            int counterb = 0;

            int replayHitA = 1;
            int replayHitB = 1;

            String xcord, ycord;
            int x = -1, y = -1;

            label10:
            while (replayHitA == 1) {

                output.outputValue(a.player + " : Enter the x coordinate :");
                xcord = S.next();
                output.outputValue(a.player + " : Enter the y coordinate :");
                ycord = S.next();

                if (xcord.matches("\\d+") && ycord.matches("\\d+")) {
                    x = Integer.parseInt(xcord);
                    y = Integer.parseInt(ycord);
                } else {
                    output.outputValue("Please enter Integer values");
                    continue label10;
                }

                if (x < b.o.maxrow && x < b.o.maxcol && x >= b.o.minrow && x >= b.o.mincol) {
                    if (b.o.oc[x][y] == '~') {
                        b.o.oc[x][y] = b.Miss;
                        pla.oc[x][y] = b.Miss;
                        output.outputValue("That was a miss.");
                        replayHitA = 0;
                        //Below for loop used to save the miss
                        pla.DisplaytheOcean(pla, b.player);
                        System.out.println("Handed over to next player");

                        battleShipClientInterface.playTheGame(a, b, pla, plb);

                    } else if (b.o.oc[x][y] == b.Miss || b.o.oc[x][y] == b.Hit) {
                        replayHitA = 0;
                        output.outputValue("This coordinates were supplied earlier.Handed over to next player");
                        battleShipClientInterface.playTheGame(a, b, pla, plb);
                    } else {
                        //Below for loop used to save the Hit
                        b.o.oc[x][y] = b.Hit;
                        pla.oc[x][y] = b.Hit;
                        output.outputValue("That was a Hit.");

                        replayHitA = 1; // Set this to one if there is a hit so that the player have one more chace to play

                        pla.DisplaytheOcean(pla, b.player);

                    }
                    //This loop is used to increment the counter. The total number of coordinates used by ships are 11(4+3+2+2)
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
                        battleShipClientInterface.stopFunction(a.player + " Wins. You Lose" );
                        System.exit(0);

                    }
                } else {
                    output.outputValue("Invalid Input");
                    continue label10;
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        //To send data to Client, we need to register the interface in registry
        BattleShip battleServer = new BattleShip();
        BattleShipServerInterface battleStub = (BattleShipServerInterface) UnicastRemoteObject.exportObject(battleServer, 0);

        Registry registry = LocateRegistry.createRegistry(8172);
        registry.bind("BattleShipServerInterface", battleStub);

        byte[] b = new byte[1024];

        int minrow = 0;
        int mincol = 0;
        int maxrow = 10;
        int maxcol = 10;

    }
}
package BattleShip4;

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

        Player playerA = new Player(aOcean, "player a", 'H', 'm');
        Player playerB = new Player(bOcean, "player b", 'H', 'm');
        //Playerr x = new Playerr();

        playerA.createTheFleet(playerA, playerA.player);
        playerB.createTheFleet(playerB, playerB.player);

        System.out.println("The Ocean of player A is : ");
        for (int i = 0; i < maxrow; i++) {
            for (int j = 0; j < maxrow; j++) {
                System.out.print(playerA.o.oc[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }
        System.out.println("The Ocean of player B is : ");
        for (int i = 0; i < maxrow; i++) {
            for (int j = 0; j < maxrow; j++) {
                System.out.print(playerB.o.oc[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }
        playerA.playGameWith(playerB);

    }
}
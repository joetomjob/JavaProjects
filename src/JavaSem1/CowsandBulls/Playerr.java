package CowsandBulls;

import java.util.Scanner;
//This class is used to write the function to play the game
class Playerr extends Fleet implements Ship{

    Ocean pl;
    String PlayerName;
    char Bull;
    char Cow;

    public Playerr() {
    }

    //This function is used to play the game
    public Playerr(Ocean p, String pla) {
        this.pl = p;
        this.PlayerName = pla;
    }

    //This function is used to play the game.

    public void playGameWith(Playerr player2) {
        Scanner s = new Scanner(System.in);
        label1:
        while (true) {
            Ocean plaA;
            Ocean plaB;
            label11:
            while (true) {
                try {
                    plaA = new Ocean();
                    Scanner S = new Scanner(System.in);
                    label12:
                    for (int i = 0; i < 4; i++) {
                        System.out.println(this.PlayerName + " : Enter " + i + " th digit of the 4 digit number: ");
                        int x = S.nextInt();
                        if (x >= 0 && x <= 9) {
                            for (int j = 0; j <= i; j++) {
                                if (plaA.number[j] == x) {
                                    System.out.println("Same digit cannot be entered twice.");
                                    --i;
                                    continue label12;
                                }
                            }
                            plaA.number[i] = x;
                        } else {
                            --i;
                            System.out.println("Enter a number between 0 and 9");
                            continue label12;
                        }
                    }

                    break label11;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid Input");
                    continue label11;
                }
            }
            int bullcountA = 0;
            int cowcountA = 0;

            for (int i = 0; i < 4; i++) {
                if (plaA.number[i] == player2.pl.number[i]) {
                    bullcountA++;
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (plaA.number[i] == player2.pl.number[j]) {
                        cowcountA++;
                    }
                }
            }
            System.out.println();
            for (int i = 0; i < 4; i++) {
                System.out.print(plaA.number[i]);
            }
            System.out.println();
            System.out.println(bullcountA + "B and " + (cowcountA - bullcountA) + "C");
            if (bullcountA == 4) {
                System.out.println(this.PlayerName + " Wins");
                System.exit(0);
            }

            label21:
            while (true) {
                try {
                    plaB = new Ocean();
                    Scanner S = new Scanner(System.in);
                    label22:
                    for (int i = 0; i < 4; i++) {
                        System.out.println(player2.PlayerName + " : Enter " + i + " th digit of the 4 digit number: ");
                        int x = S.nextInt();
                        if (x >= 0 && x <= 9) {
                            for (int j = 0; j <= i; j++) {
                                if (plaB.number[j] == x) {
                                    System.out.println("Same digit cannot be entered twice.");
                                    --i;
                                    continue label22;
                                }
                            }
                            plaB.number[i] = x;
                        } else {
                            --i;
                            System.out.println("Enter a number between 0 and 9");
                            continue label22;
                        }

                    }
                    break label21;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid Input");
                    continue label21;
                }
            }
            int bullcountB = 0;
            int cowcountB = 0;

            for (int i = 0; i < 4; i++) {
                if (plaB.number[i] == this.pl.number[i]) {
                    bullcountB++;
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (plaB.number[i] == this.pl.number[j]) {
                        cowcountB++;
                    }
                }
            }
            System.out.println();
            for (int i = 0; i < 4; i++) {
                System.out.print(plaB.number[i]);
            }
            System.out.println();
            System.out.println(bullcountB + "B and " + (cowcountB - bullcountB) + "C");

            if (bullcountB == 4) {
                System.out.println(player2.PlayerName + " Wins");
                System.exit(0);
            }
        }
    }

    public void createTheFleet(Player player, String str, Playerr plaCandB) {
        Ocean pp;
        label111:
        while (true) {
            try {
                pp = new Ocean();
                Scanner S = new Scanner(System.in);
                label112:
                for (int i = 0; i < 4; i++) {
                    System.out.println(plaCandB.PlayerName + " : Enter " + i + " th digit of the 4 digit number: ");

                    int x = S.nextInt();
                    if (x >= 0 && x <= 9) {
                        for (int j = 0; j <= i; j++) {
                            if (pp.number[j] == x) {
                                System.out.println("Same digit cannot be entered twice.");
                                --i;
                                continue label112;
                            }
                        }
                        pp = CreateShip(pp, i, x,"none", 'n', 0);
                    } else {
                        --i;
                        System.out.println("Enter a number between 0 and 9");
                        continue label112;
                    }
                }
                plaCandB.pl = pp;
                break label111;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid Input");
                continue label111;
            }
        }

    }

    public Ocean CreateShip(Ocean r, int m, int n, String p, char b, int len) {

        r.number[m] = n;
        return r;
    }

}

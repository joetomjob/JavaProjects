package CowsandBulls;

public class CowsandBulls {
    public static void main(String[] args) {

        Ocean pl1 = new Ocean();
        Ocean pl2 = new Ocean();

        Playerr playerA = new Playerr(pl1, "Player A");
        Playerr playerB = new Playerr(pl2, "Player B");

        Player x = new Player();

        playerA.createTheFleet(x,"a",playerA);
        playerB.createTheFleet(x,"b",playerB);

        System.out.println("The number of player A is : ");
        for (int i = 0; i < 4; i++) {
            System.out.print(playerA.pl.number[i]);
        }
        System.out.print('\n');
        System.out.println("The number of player B is : ");
        for (int i = 0; i < 4; i++) {
            System.out.print(playerB.pl.number[i]);
        }
        System.out.print('\n');

        playerA.playGameWith(playerB);

    }
}
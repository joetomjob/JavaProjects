package BattleShip11.View;

import java.util.Scanner;

public class InputView {

    public String inputTheValue(String string){
        Scanner S = new Scanner(System.in);
        String inputString;
        System.out.println(string);
        inputString = S.next();
        return inputString;
    }
}

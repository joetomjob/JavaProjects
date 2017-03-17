package BattleShipTCP;

import java.io.Serializable;
import java.util.Scanner;

public class InputView implements Serializable {

    public String inputTheValue(String string){
        Scanner S = new Scanner(System.in);
        String inputString;
        System.out.println(string);
        inputString = S.next();
        return inputString;
    }
}

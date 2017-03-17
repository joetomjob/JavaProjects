package BattleShipSwing;

import java.io.Serializable;
import java.util.Scanner;

public class BattleShipView implements Serializable{

    public String inputTheValue(String string){
        Scanner S = new Scanner(System.in);
        String inputString;
        System.out.println(string);
        inputString = S.next();
        return inputString;
    }
    public void outputChar(char string){
        System.out.print(string);
    }
    public void outputValue(String string){
        System.out.println(string);
    }
}

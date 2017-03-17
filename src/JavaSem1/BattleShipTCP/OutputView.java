package BattleShipTCP;

import java.io.Serializable;

public class OutputView implements Serializable {
    public void outputChar(String string){
        System.out.print(string);
    }
    public void outputValue(String string){
        System.out.println(string);
    }
}

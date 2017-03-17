package AlgorithmsHW.HW3;

import java.util.Scanner;

/**
 * Created by Admin on 3/15/2017.
 */
public class MorseVowel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Take the input; n = the total number of elements in the string
        Integer n = in.nextInt();
        in.nextLine();

        //take the values of n characters representing the morse code
        String code = in.nextLine();

        char[] codeArray = new char[n];
        codeArray = code.toCharArray();

        String[][] vowelList = new String[5][2];
        vowelList[0][0] = "E";
        vowelList[0][1] = ".";

        vowelList[1][0] = "I";
        vowelList[1][1] = "..";

        vowelList[2][0] = "A";
        vowelList[2][1] = ".-";

        vowelList[3][0] = "O";
        vowelList[3][1] = "---";

        vowelList[4][0] = "U";
        vowelList[4][1] = "..-";


    }
}

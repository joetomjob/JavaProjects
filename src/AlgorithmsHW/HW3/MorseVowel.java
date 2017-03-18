/*
Given is a sequence of n symbols, each of which is either a dot (.) or a dash (-). This
can represent a sequence of letters in Morse code. However, since the separation between
letters is not given, it can represent a number of different sequences. For example, . - -
could represent ETT, AT, EM, or W.
Give an O(n) algorithm that computes the number of possible letter sequences con-
taining only vowels (A,E,I,O,U) that can be derived from the given input sequence of
dots and dashes. As your argument of correctness, state all three parts of the heart of your
solution (see below).
*/


import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Joe Tom Job.
 */
public class MorseVowel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Take the input; n = the total number of elements in the string
        Integer n = in.nextInt();
        in.nextLine();

        //take the values of n characters representing the morse code
        String code = in.nextLine();

        String[][] table = new String[5][2];
        table[0][0] = "E";
        table[0][1] = ".";

        table[1][0] = "I";
        table[1][1] = "..";

        table[2][0] = "A";
        table[2][1] = ".-";

        table[3][0] = "O";
        table[3][1] = "---";

        table[4][0] = "U";
        table[4][1] = "..-";


        int[] list = new int[code.length() + 1];
        list[0] = 0;

        for (int i = 1; i < code.length()+1; i++) {

            if (i > 0) {
                int k = count(table, Character.toString(code.charAt(i - 1)));
                if (k > 0) {
                    if(list[i-1]==0 && i-1 ==0)
                        list[i] += k;
                    else{
                        list[i] += list[i-1];}
                }
                if (i > 1) {
                    int l = count(table, "" + code.charAt(i - 2)+ code.charAt(i - 1));
                    if (l > 0) {
                        if(list[i-2]==0 && i-2 ==0)
                            list[i] += l;
                        else
                            list[i] += list[i - 2];
                    }
                }
                if (i > 2) {
                    int m = count(table, "" + code.charAt(i - 3)+ code.charAt(i - 2) + code.charAt(i - 1));
                    if (m > 0) {
                        if(list[i - 3]==0 && i-3==0)
                            list[i] += m;
                        else
                            list[i] += list[i - 3];
                    }
                }

            }
        }
        System.out.println(list[code.length()]);

    }

    private static int count(String[][] table, String s) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (table[i][1].equals(s)) {
                count++;
            }
        }
        return count;
    }
}

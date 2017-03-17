package AlgorithmsHW.HW0;

import java.io.IOException;
import java.util.Scanner;


public class HW1P1PerfectCube {
    public static void main(String args[]) throws IOException{
        Scanner in = new Scanner(System.in);
        long input = in.nextLong();
        long output = 0;
        int counter = 0;
        while(counter*counter*counter<=input){
            output = counter*counter*counter;
            System.out.println(output);
            counter++;
        }
    }
}

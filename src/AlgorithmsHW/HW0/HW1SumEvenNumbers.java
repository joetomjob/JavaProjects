package AlgorithmsHW.HW0;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Admin on 25-01-2017.
 */
public class HW1SumEvenNumbers {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);

        long input = in.nextLong();
        long output = 0;
        int counter = 1;
        while(counter<=input){
            int n = in.nextInt();
            if(n%2==0){
                output += n;
            }
            counter++;
        }
        System.out.println(output);
    }
}

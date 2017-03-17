package testing;

import java.util.ArrayList;

/**
 * Created by Admin on 08-10-2016.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] x = new int[10];

        int k = 1;
        for (int i = 1; i <= 10; i++) {
            x[i - 1] = (i * k);
            k = k * -1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print('\t');
            System.out.print(x[i]);
        }
        x = bubsort(x);
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print('\t');
            System.out.print(x[i]);
        }
    }

    public static int[] bubsort(int[] x) {

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length - 1; j++) {
                int b;
                if (x[j] > x[j + 1]) {
                    b = x[j+1];
                    x[j + 1] = x[j];
                    x[j] = b;
                }
            }
        }
        return x;
    }
}

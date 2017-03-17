package testing;

/**
 * Created by Admin on 08-10-2016.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] x = new int[10];
        int k = 1;
        for (int i = 1; i <= 10; i++) {
            x[i - 1] = (i * k);
            k = k * -1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(x[i]);
        }
        x = selSort(x);
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print('\t');
            System.out.print(x[i]);
        }
    }
    public static int[] selSort(int[] x) {

        for (int i = 0; i < x.length; i++) {
            int smallindex=i;
            int k;
            for (int j = i+1; j < x.length; j++) {
                if (x[smallindex] > x[j]) {
                    smallindex = j;
                }
            }
            k = x[smallindex];
            x[smallindex] = x[i];
            x[i] = k;
        }
        return x;
    }
}

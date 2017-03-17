package testing;

/**
 * Created by Admin on 08-10-2016.
 */
public class MergeSortSample {
    public static void main(String[] args) {
        int[] x = new int[]{12, 34, 1, 56, 33, 12, 8};
        MergeSortSample ob = new MergeSortSample();
        int len = x.length-1;
        ob.sort(x, 0, len);
        for (int i = 0; i < x.length; i++) {
            System.out.print('\t');
            System.out.print(x[i]);
        }
    }

    void sort(int[] y, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(y, l, m);
            sort(y, m + 1, r);

            merge(y, l, m, r);

        }

    }

    void merge(int[] z, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = z[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = z[m + 1 + i];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                z[k] = L[i];
                i++;
            } else {
                z[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            z[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            z[k] = R[j];
            j++;
            k++;
        }

    }
}

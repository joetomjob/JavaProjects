package testing;

/**
 * Created by Admin on 11-02-2017.
 */
public class binarySearch {
    public static void main(String[] args) {
        int[] a = {13, 24, 26, 28, 57, 64, 72, 89, 97};
        binarySearch b = new binarySearch();
        int res = b.binaryS(a, 13, 0, a.length - 1);
        System.out.println(res);

    }

    public int binaryS(int[] a, int k, int l, int r) {
        if (l <= r) {
            int m = (l + r) / 2;

            if (a[m] == k) {
                return m;
            } else if (a[m] > k) {
                return binaryS(a, k, l, m - 1);
            } else {
                return binaryS(a, k, m + 1, r);
            }
        } else {
            return -1;
        }
    }

}

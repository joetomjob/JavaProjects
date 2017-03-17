package Int;

/**
 * Created by Admin on 12-10-2016.
 */
public class micro_ganesh_summer {
    //given an array a = [2,5,8,10,3]. Find the adjacent pair with max sum. What if the question is to find  triplets , quadruplets ...
    public static void main(String args[]) {
        int[] a = new int[]{2, 5, 8, 10, 3};
        int sum = 0;
        for (int i = 0; i < a.length - 2; i++) {
            int x = a[i] + a[i + 1] + a[i + 2];
            if (x > sum) {
                sum = x;
            }
        }
        System.out.println(sum);
    }
}

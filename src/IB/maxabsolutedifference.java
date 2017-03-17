package IB;
import java.util.*;

/**
 * Created by Admin on 28-12-2016.
 */
public class maxabsolutedifference {

    public int maxArrOptimal(ArrayList<Integer> A) {
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        int min1 = Integer.MIN_VALUE;
        int min2 = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i <A.size();i++){
            max1 = Math.max(max1,A.get(i)+(i+1));
            max2 = Math.max(max2,A.get(i)-(i+1));
            min1 = Math.min(min1,A.get(i)+(i+1));
            min2 = Math.min(min2,A.get(i)-(i+1));
        }
        ans = Math.max(ans, max2-min2);
        ans = Math.max(ans, max1-min1);
        return ans;
    }

    public int maxArr(ArrayList<Integer> A) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <A.size();i++){
            int sum = 0;
            for(int j = i; j < A.size(); j++){
                sum = Math.abs(A.get(i)-A.get(j))+Math.abs((i+1)-(j+1));
                ans = Math.max(sum,ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList x = new ArrayList();
        maxabsolutedifference r = new maxabsolutedifference();
        x.add(-12);
        x.add(-1);
        x.add(-2);
        x.add(-3);
        x.add(19);
        x.add(-9);
        x.add(-3);

        int l = r.maxArr(x);
        System.out.println(l);
        int m = r.maxArrOptimal(x);
        System.out.println(m);
    }
}

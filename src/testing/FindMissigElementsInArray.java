package testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12-02-2017.
 */
public class FindMissigElementsInArray {
    public List<Integer> missingElement(int[] a) {
        ArrayList<Integer> k = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            a[Math.abs(a[i]) - 1] = -Math.abs(a[Math.abs(a[i]) - 1]);
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i]>0){
                k.add(i+1);
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 1, 6, 7, 6, 8};
        FindMissigElementsInArray f = new FindMissigElementsInArray();
        List<Integer> k = new ArrayList<Integer>();
        k = f.missingElement(a);
        for (int i = 0; i < k.size(); i++) {
            System.out.println(k.get(i));
        }


    }
}

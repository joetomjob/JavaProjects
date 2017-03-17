package IB;

import java.util.*;

/**
 * Created by Admin on 03-01-2017.
 */
public class KthRowPascalsTriangle {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < a; i++) {
            int val;
            int last = 0;
            for (int j = 0; j < i+1; j++) {
                val = res.get(j);
                if(j-1>=0){
                    val += last;
                }
                last = res.get(j);
                res.set(j,val);
            }
            res.add(res.get(0));
        }
        return res;
    }

    public static void main(String[] args) {
        KthRowPascalsTriangle k = new KthRowPascalsTriangle();
        ArrayList<Integer> x = new ArrayList<>();
        x = k.getRow(4);
        for (int i = 0; i < 5 ; i++) {
            System.out.print(x.get(i));
            System.out.print(" ");
        }

    }
}

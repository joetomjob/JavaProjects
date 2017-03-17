package IB;

import java.util.ArrayList;
import java.util.List;

public class Spiral2D{
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int k = 0;
        int m = a.size();
        int n = a.get(0).size();

        if(m==0){
            return result;
        }
        int dir =0;
        int l =0,row =0,col=0,layer=0;

        result.add(a.get(0).get(0));

        for (int i = 0; i < m*n ; i++) {
            switch (dir){
                case 0 :
                    if(col == n-layer-1){
                        dir=1;
                        row++;
                    }
                    else{
                        col++;
                    }
                    break;
                case 1:
                    if(row == m-layer-1){
                        dir=2;
                        col--;
                    }
                    else{
                        row++;
                    }
                    break;
                case 2:
                    if(col == layer){
                        dir=3;
                        row--;
                }
                    else{
                        col--;
                    }
                    break;
                case 3:
                    if(row == layer+1){
                        dir=0;
                        col++;
                        layer++;

                    }
                    else{
                        row--;
                    }
                    break;
            }
            result.add(a.get(row).get(col));

        }
        return result;
        }


    public static void main(String args[]){
        List<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <3 ; i++) {
            ArrayList<Integer> k = new ArrayList<Integer>();
            for (int j = 0; j <3 ; j++) {
                k.add(j);
            }
            x.add(k);
        }
        Spiral2D r = new Spiral2D();
        ArrayList<Integer> m = new ArrayList<Integer>();
        m = r.spiralOrder(x);


        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                System.out.print(x.get(i).get(j));
                System.out.print("\t");
            }
            System.out.print("\n");
        }

        System.out.println();
        for (Integer a : m) {
            System.out.print(a);
            System.out.print("\t");

        }

    }
}
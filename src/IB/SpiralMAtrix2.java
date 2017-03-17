package IB;

import java.util.ArrayList;

/**
 * Created by Admin on 17-01-2017.
 */
public class SpiralMAtrix2 {
    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (a == 0){
            return result;
        }
        for(int i = 0;i<a; i++){
            result.add(new ArrayList());
            for(int j = 0;j<a;j++){
                result.get(i).add(0);
            }
        }
        int row,col,dir,layer;
        row = col = dir = layer = 0;
        result.get(0).set(0,1);
        for(int i = 2;i<=a*a;i++){
            switch(dir){
                case 0:
                    if(col == a-layer-1){
                        row++;
                        dir = 1;
                    }
                    else{
                        col++;
                    }
                    break;
                case 1:
                    if(row == a-layer-1){
                        col--;
                        dir = 2;
                    }
                    else{
                        row++;
                    }
                    break;
                case 2:
                    if (col == layer){
                        row--;
                        dir = 3;
                    }
                    else{
                        col--;
                    }
                    break;
                case 3:
                    if(row == layer+1){
                        col++;
                        dir = 0;
                        layer++;
                    }
                    else{
                        row--;
                    }
                    break;
            }
            result.get(row).set(col,i);
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        SpiralMAtrix2 p = new SpiralMAtrix2();
        res = p.generateMatrix(5);
        for (int i = 0; i < res.size() ; i++) {
            System.out.println(res.get(i));
        }
    }
}

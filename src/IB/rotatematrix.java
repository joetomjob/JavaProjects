package IB;
import java.util.*;
/**
 * Created by Admin on 21-01-2017.
 */
public class rotatematrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> result  = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.size();i++){
            result.add(new ArrayList<Integer>());
        }
        for(int i=0;i<a.size();i++){
            for(int j=0;j<a.size();j++){
                result.get(i).add(a.get(a.size()-1-j).get(i));
            }
        }
        a = result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        rotatematrix rm = new rotatematrix();
        r.add(new ArrayList<Integer>());
        r.add(new ArrayList<Integer>());
        r.get(0).add(1);
        r.get(0).add(2);
        r.get(1).add(3);
        r.get(1).add(4);
        rm.rotate(r);
    }
}

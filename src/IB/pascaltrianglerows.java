package IB;
import java.util.*;
/**
 * Created by Admin on 17-01-2017.
 */

public class pascaltrianglerows {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList());
        if(a==0){
            return result;
        }
        result.get(0).add(1);

        for(int i =1;i<a;i++){
            result.add(new ArrayList());
            result.get(i).add(1);
            for(int j = 0; j<i-1;j++){
                int n = result.get(i-1).get(j)+result.get(i-1).get(j+1);
                result.get(i).add(n);
            }
            result.get(i).add(1);
        }
        return(result);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        pascaltrianglerows p = new pascaltrianglerows();
        res = p.generate(5);
        for (int i = 0; i < res.size() ; i++) {
            System.out.println(res.get(i));
        }
    }
}

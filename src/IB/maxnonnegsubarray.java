package IB;
import java.util.*;
/**
 * Created by Admin on 29-12-2016.
 */
public class maxnonnegsubarray {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        long sum = 0;
        long tempsum = 0;
        long count = 0;
        long r = -1;
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)>=0){
                sum += a.get(i);
                temp.add(a.get(i));
            }
            else{
                sum = 0;
                temp = new ArrayList<>();
            }
            if(sum > tempsum){
                tempsum = sum;
                ans = temp;
            }
            else if (sum == tempsum){
                if(ans.size() < temp.size()){
                    ans = temp;
                }
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        ArrayList x = new ArrayList();
        maxnonnegsubarray r = new maxnonnegsubarray();
        x.add(0);
        x.add(0);
        x.add(-1);
        x.add(0);

        ArrayList l = r.maxset(x);
        for (int i = 0; i <l.size() ; i++) {
            System.out.println(l.get(i));
        }
    }
}

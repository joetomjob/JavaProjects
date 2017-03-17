package IB;
import java.util.*;
/**
 * Created by Admin on 28-12-2016.
 */
public class RepeatandMissingNumberArray {
    public ArrayList<Integer>  repeatedNumberOptimal(final List<Integer> a) {
        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(a);
        int rep = 0;
        int miss = 0;
        long sum = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if(a.get(i).intValue() == a.get(i-1).intValue()){
                rep =a.get(i);
            }
            sum += a.get(i);
        }

        miss = (int) ((1L * a.size() * (1L * a.size() + 1)) / 2 - sum + rep);
        ans.add(rep);
        ans.add(miss);

        return ans;
    }

    public ArrayList<Integer>  repeatedNumber(final List<Integer> a) {
        long sum = 0 ,sumsquare = 0, actSum = 0,actSumssq = 0;
        for (int i = 0;i<a.size();i++){
            sum += (i+1);
            sumsquare += Math.pow((i+1),2);
            actSum += a.get(i);
            actSumssq += Math.pow(a.get(i),2);
        }
        long x=0,y=0,r=0;
        x = actSum - sum;
        y = actSumssq - sumsquare;
        r = (int)(1L*y)/x;
        long l = (int)(1L*(r+x))/2;
        long m = (int)(1L*(r-x))/2;
        ArrayList n = new ArrayList();
        n.add(l);
        n.add(m);
        return n;
    }

    public static void main(String[] args) {
        ArrayList x = new ArrayList();
        RepeatandMissingNumberArray r = new RepeatandMissingNumberArray();
        x.add(2);
        x.add(2);
        x.add(3);
        x.add(4);
        x.add(5);


        ArrayList l = r.repeatedNumber(x);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

    }
}

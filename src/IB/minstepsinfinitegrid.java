package IB;
import java.util.*;

public class minstepsinfinitegrid {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int numSteps = 0;
        for (int i = 1;i<X.size();i++){
            numSteps += Math.max(Math.abs(X.get(i)-X.get(i-1)),Math.abs(Y.get(i)-Y.get(i-1)));
        }
        return numSteps;
    }

    public static void main(String[] args) {
        minstepsinfinitegrid z = new minstepsinfinitegrid();
        ArrayList x = new ArrayList();
        ArrayList y = new ArrayList();
        x.add(2);
        x.add(2);
        x.add(2);
        y.add(2);
        y.add(11);
        y.add(11);
        int s = z.coverPoints(x,y);
        System.out.println(s);
    }
}

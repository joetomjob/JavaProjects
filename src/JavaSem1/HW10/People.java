package HW10;

import java.util.ArrayList;

public class People extends Thread {

    int nooffloors;
    static ArrayList<ArrayList<Integer>> peoplearr;
    public static String lock;
    final static int weightlowerbound = 40;
    final static int weightupperbound = 100;


    public People(int n) {
        nooffloors = n;
        peoplearr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            peoplearr.add(temp);
        }
    }

    public Integer randomnumber(int lb, int ub) {
        int k = (int) (Math.random() * ((ub - lb)) + lb);
        return k;
    }

    public void run() {
        while (true) {

            int people = randomnumber(weightlowerbound, weightupperbound);
            int floor = randomnumber(0, nooffloors);

            enterleavefloor(true,floor,people);
            //peoplearr.get(floor).add(people);

            try{
                sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public synchronized void enterleavefloor(boolean flag,int floor,int person){
        if(flag){
            peoplearr.get(floor).add(person);
        }
        else{
            peoplearr.get(floor).remove(person);
        }
    }
    public ArrayList<Integer> getpersonforfloor(int floor){
        return peoplearr.get(floor);
    }

}

package HW10;

import java.util.ArrayList;

public class Elevator extends Thread {
    static int nooffloors;
    static ArrayList<Integer> pinelevator = new ArrayList<>();
    People people;
    static final int maxcapacity = 300;

    public Elevator(int n, People p) {
        nooffloors = n;
        people = p;
    }

    public void run() {
        int count = 0;
        boolean countflag = true;
        while (true) {
            int currentfloor = count;

            System.out.println("\nLift is at the floor : " + currentfloor);

            //People start exiting the elevator
            if (pinelevator.size() > 0) {
                ArrayList<Integer> exitedlist = new ArrayList<Integer>(); //to print values at end
                int nofPeopleExiting = people.randomnumber(1, pinelevator.size());
                int s = 1;
                if (nofPeopleExiting > 0) {
                    while (s <= pinelevator.size()) {
                        if (s <= nofPeopleExiting) {
                            int indextobeexited = people.randomnumber(0, pinelevator.size() - 1);
                            exitedlist.add(pinelevator.get(indextobeexited));
                            pinelevator.remove(indextobeexited);
                        } else {
                            break;
                        }
                        s++;
                    }
                    System.out.println(exitedlist.size() + " people are exiting from the elevator");
                    System.out.print("The persons being exited has weights : ");
                    for (int i = 0; i < exitedlist.size(); i++) {
                        System.out.print(exitedlist.get(i) + ", ");
                    }
                }
            }

            //Now people start entering into the elevator
            ArrayList<Integer> cntinafloor = new ArrayList<Integer>();
            cntinafloor = people.getpersonforfloor(currentfloor);
            int d = 0;
            ArrayList<Integer> peopleEntering = new ArrayList<Integer>();

            while (d < cntinafloor.size()) {
                if (presentweight() + cntinafloor.get(d) < maxcapacity) {
                    int f = cntinafloor.get(d);
                    people.enterleavefloor(false, currentfloor, d);
                    pinelevator.add(f);
                    peopleEntering.add(f);
                    cntinafloor = people.getpersonforfloor(currentfloor);
                } else {
                    break;
                }
                d++;
            }
            if (peopleEntering.size() > 0) {
                System.out.println("\nThe people entering the elevator are : ");
                for (int i = 0; i < peopleEntering.size(); i++) {
                    System.out.print(peopleEntering.get(i) + ", ");
                }
                System.out.println();
            }
            if (pinelevator.size() > 0) {
                System.out.println("\nThe people in the elevator are : ");
                for (int i = 0; i < pinelevator.size(); i++) {
                    System.out.print(pinelevator.get(i) + ", ");
                }
                System.out.println();
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == nooffloors - 1) {
                countflag = false;
            }
            if (count == 0) {
                countflag = true;
            }

            if (countflag == true) {
                count++;
            } else {
                count--;
            }
        }
    }

    public Integer presentweight() {
        int wt = 0;
        for (int i = 0; i < pinelevator.size(); i++) {
            wt += pinelevator.get(i);
        }
        return wt;
    }

    public static void main(String[] args) {
        int noOffloors = 10;
        //int noOffloors = Integer.parseInt(args[0]);
        if (noOffloors >= 2) {
            People p = new People(noOffloors);
            Elevator e = new Elevator(noOffloors, p);

            p.start();
            e.start();
        } else {
            System.out.println("Please enter a value greater than 1");
        }

    }
}

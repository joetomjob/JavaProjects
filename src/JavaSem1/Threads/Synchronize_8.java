package Threads;

import java.util.*;

public class Synchronize_8 extends Thread    {
    private String info;
    private Vector aVector;

    public Synchronize_8 (String info, Vector aVector) {
        this.info    = info;
        this.aVector = aVector;
    }

    private void inProtected_1 () {
        synchronized ( aVector )	{
            System.err.println("1: " + info + ": is in ");
            try {
                sleep(1000);
            }
            catch (  InterruptedException e ) {
                System.err.println("Interrupted!");
            }
            System.err.println("1: " + info + ": exit");
        }
    }

    private void inProtected_2 () {
        synchronized ( info )	{
            System.err.println("2: " + info + ": is IN ");
            try {
                sleep(5000);
            }
            catch (  InterruptedException e ) {
                System.err.println("Interrupted!");
            }
            System.err.println("2: " + info + ": EXIT");
        }
    }

    private static void inProtected_3 () {
        System.err.println("3: IN ");
        try {
            sleep(9000);
        }
        catch (  InterruptedException e ) {
            System.err.println("Interrupted!");
        }
        System.err.println("3: EXIT");
    }

    public void run () {
        inProtected_1();
        inProtected_2();
        Synchronize_8.inProtected_3();
        /* synchronized on avector because we are using same avector. Not synchronized on info because different info .
        inprotected3 is not at all synchronized*/
    }

    public static void main (String args []) {
        Vector aVector = new Vector();
        Synchronize_8 aT6_0 = new Synchronize_8("first",  aVector);
        Synchronize_8 aT6_1 = new Synchronize_8("second", aVector);

        aT6_0.start();
        aT6_1.start();
    }
}
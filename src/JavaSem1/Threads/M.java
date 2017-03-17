package Threads;

import java.util.*;

public class M extends Thread    {
    private String info;
    private Vector aVector;

    public M (String info) {
        this.info = info;
    }

    private synchronized void inProtected (String lol) {
        System.err.println(info + ": is in protected() "+lol);
        try {
            sleep(1000);
        }
        catch (  InterruptedException e ) {
            System.err.println("Interrupted!");
        }
        System.err.println(info + ": exit run "+lol);
    }

    public void run () {
        inProtected("run");
    }

    public static void main (String args []) {
        Vector aVector = new Vector();
        M aT4_0 = new M("first");

        aT4_0.start();

        aT4_0.inProtected("not run");
     }
}
package Threads;

import java.util.*;
/**
 * Created by Admin on 23-10-2016.
 */
public class Synchronize_4 extends Thread{
    private String info;
    private Vector aVector = new Vector(); /* if this is changed to static, it will work, since it will be using same aVector.
                                            But now it wont work since new aVector will be created for different objects*/

    public Synchronize_4 (String info) {
        this.info = info;
    }

    public void inProtected () {
        synchronized ( aVector )     {
            System.err.println(info + ": is in protected()");
            try {
                sleep(3000);
            }
            catch (  InterruptedException e ) {
                System.err.println("Interrupted!");
            }
            System.err.println(info + ": exit run");
        }
    }

    public void run () {
        inProtected();
    }

    public static void main (String args []) {
        Synchronize_4 aT5_0 = new Synchronize_4("first");
        Synchronize_4 aT5_1 = new Synchronize_4("second");

        aT5_0.start();
        aT5_1.start();
    }

}

package Threads;
import java.util.*;
/**
 * Created by Admin on 23-10-2016.
 */
public class Synchronize_6 extends Thread{
    private String info;
    static Vector aVector;

    public Synchronize_6 (Vector aVector, String info) {
        this.aVector = aVector;
        this.info    = info;
    }

    public void inProtected () {
        synchronized ( aVector )     {
            System.err.println(info + ": is in protected()");
            try {
                sleep(100);
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
        Vector aVector = new Vector();
        Synchronize_6 aT5_0 = new Synchronize_6(aVector, "first");
        aT5_0.start();
        try { sleep(1000); } catch (  InterruptedException e ) { System.err.println("Interrupted!"); }

        aVector = new Vector();
        Synchronize_6 aT5_1 = new Synchronize_6(aVector, "second");
        aT5_1.start();
        //this is written to show the previous progra is not synchronized. sleep 1000 is written here
    }
}

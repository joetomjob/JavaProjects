package Threads;
import java.util.*;
/**
 * Created by Admin on 23-10-2016.
 */
public class Synchronize_2 extends Thread{
    private String info;
    private Vector aVector;

    public Synchronize_2 (String info, Vector aVector) {
        this.info    = info;
        this.aVector = aVector;
    }

    private synchronized void inProtected () {
        System.err.println(info + ": is in protected()");
        aVector.addElement(info);
        try {
            if ( info.equals("second") )
                sleep(1000);
            else
                sleep(3000);
        }
        catch (  InterruptedException e ) {
            System.err.println("Interrupted!");
        }
        System.err.println(info + ": exit run");
    }

    public void run () {
        inProtected();
    }

    public static void main (String args []) {
        Vector aVector = new Vector();
        Synchronize_2 aT4_0 = new Synchronize_2("first",  aVector);
        Synchronize_2 aT4_1 = new Synchronize_2("second", aVector);

        aT4_0.start(); /*Here synchronize is written on method protected, Therefore the method protected checks on which object it is called.
        if we call the method sychronized on the same object, it will run as we need. But here the protected method which is synchronized is
        called on 2 objects. Therefore they are independent. Also note that the method protected is not static*/
        aT4_1.start();
    }
}

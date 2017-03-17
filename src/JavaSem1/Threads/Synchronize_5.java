package Threads;
import java.util.*;
/**
 * Created by Admin on 23-10-2016.
 */
public class Synchronize_5 extends Thread{
    private String info;
    static Vector aVector;

    public Synchronize_5 (Vector aVector, String info) {
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
        Synchronize_5 aT5_0 = new Synchronize_5(aVector, "first");
        aT5_0.start();

        System.out.println(" ");

        aVector = new Vector(); // here it can and cannot be synchronized. even though it seems to be synchronized.
        // If we don't put the print ln statement above, it seems to be synchronized.
        /*This can be synchronized on same aVector on top which is static
        * 1st case : at5_0 starts and goto protected and puts a lock on aVector at top whose memory location now is defined by the above initialization.
        *Then aVector is initialized again and the value of aVector changes. ie the memory loacation changes and then at5_1 starts and
        * puts a lock on protected method with aVector at top. But now aVector has a new memory address. In this case they are not synchronized
        * 2nd case : at5_0 starts and goto protected and stops there.Then aVector is initialized again and the value of aVector changes.
        * ie the memory loacation changes and then at5_1 starts and go to protected method and puts a lock on protected method
        * with aVector at top. Here aVector has a same memory address for both objects . In this case they are synchronized*/
        Synchronize_5 aT5_1 = new Synchronize_5(aVector, "second");
        aT5_1.start();
    }
}

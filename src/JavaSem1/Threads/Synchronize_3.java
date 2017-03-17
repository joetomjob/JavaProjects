package Threads;
import java.util.*;
/**
 * Created by Admin on 23-10-2016.
 */
public class Synchronize_3 extends Thread{
    private String info;
    static Vector aVector;

    public Synchronize_3 (String info, Vector aVector) {
        this.info = info;
        this.aVector = aVector;
    }

    public void inProtected () {
        synchronized ( aVector )     {
            System.err.println(info + ": is in protected()");
            try {
                if ( info.equals("second") )
                    sleep(1000);
                else
                    sleep(1000);
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
        Vector aVector1 = new Vector();

        Synchronize_3 aT5_0 = new Synchronize_3("first", aVector); /*Since we are synchronizing 2 objects on one object aVector, both objects
                                                                     are synchronized*/
        /*different possibilities : 1) the aVector in top is not static and we are passing same aVector here. It will be synchronized
        * doubt abt this point - syncho2) the vector in top is static and we are passing 2 different aVectors here. It will be synchronized on aVector at top because
        * since the above aVector is static, no matter how many objects we create for the class, the aVecor at top will be initialized
        * only once.
        * 3)top  aVector is not static and we are passing different aVectors here. It wont be synchronized*/

        Synchronize_3 aT5_1 = new Synchronize_3("second", aVector1);

        aT5_0.start();
        System.out.println();
        aT5_1.start();
    }
}

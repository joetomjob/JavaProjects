package Threads;
import java.util.Vector;

public class WaitAndNotify_First extends Thread	{

    private static int counter = 0;
    private String  name = null;
    private Vector aVector;

    public WaitAndNotify_First (String name, Vector aVector) {
        this.aVector = aVector;
        this.name = name;

    }

    public void run () {
        synchronized ( aVector )	{
            if (   name.equals("two")  )	{
                System.out.println(getName() + " will wait ...");
                aVector.notify();
                System.out.println(getName() + " done.");
            } else {
                System.out.println(getName() + " will wait ...");
                try {
                    new WaitAndNotify_First("two", aVector).start();
                    aVector.wait();
                } catch ( IllegalMonitorStateException  e )	{
                    System.out.println( ": IllegalMonitorStateException");
                } catch ( InterruptedException  e )	{
                    System.out.println(": InterruptedException");
                }
                System.out.println(getName() + " is awake!");
            }
        }
    }


    public static void main (String args []) {
        Vector theVector = new Vector();

        new WaitAndNotify_First("one", theVector).start();
        /* wait can only be called inside a synchronized block. If we call wait it will handover the lock. So that that synchronized block
        * will lose the control.
        * To resume the control.  we need to call the notify the function from same object
        * Notify also can be called only in a synchronized block
        * If we dont call notify, then, the other thread cant resume by getting the control
        * If we call notifyall, then all threads will be notified*/
    }
}

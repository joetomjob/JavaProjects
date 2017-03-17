package Threads;

import java.util.Vector;

public class WaitandNotify_1 extends Thread	{

    private String info;
    static  Vector aVector = new Vector();

    public WaitandNotify_1 (String info, Vector aVector) {
        this.info = info;
        this.aVector = aVector;
    }

    public void doTheJob() {
        synchronized ( aVector )	{
            if (  info.equals("last") )	{
                System.out.println(info + " is waking up ...");
                aVector.notifyAll();
                System.out.println(info + " done.");
            } else {
                System.out.println(info + " is waiting");
                try {
                    aVector.wait();
                } catch ( IllegalMonitorStateException  e )	{
                    System.out.println(info +
                            ": IllegalMonitorStateException");
                } catch ( InterruptedException  e )	{
                    System.out.println(info +
                            ": InterruptedException");
                }
                System.out.println(info + " is awake!");
            }
        }
    }


    public void run () {
        doTheJob();
    }

    public static void main (String args []) {
        new WaitandNotify_1("first", aVector).start();
        new WaitandNotify_1("second", aVector).start();
        new WaitandNotify_1("last", aVector).start();

        /*Here if schedluer calls "new WaitandNotify_1("last", aVector).start();" first, then it will call notifyall inside that
        and when first and second is called, it is waited and then first will be run and that also will be waited and the program will be stuck
         */
    }

}
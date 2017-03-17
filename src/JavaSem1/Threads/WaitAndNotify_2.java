package Threads;

import java.util.Vector;

public class WaitAndNotify_2 extends Thread	{

    private String info;
    static Integer monitor = new Integer(3);
    static int count = 0;
    static int max = 0;

    public WaitAndNotify_2 (String info) {
        this.info = info;
        // max ++;
    }

    public void doTheJob() {
        synchronized ( monitor )	{
            System.out.println(info + " is waiting");
            count ++;
            // if ( count == max );
            if ( count == 3 )
                monitor.notifyAll();
            else
                try {
                    monitor.wait();
                    sleep(1000);
                } catch ( Exception  e )	{
                    System.out.println(info +
                            ": IllegalMonitorStateException");
                }
            System.out.println(info + " is awake!");
        }
    }


    public void run () {
        doTheJob();
    }

    public static void main (String args []) {
        new WaitAndNotify_2("first").start();
        new WaitAndNotify_2("second").start();
        new WaitAndNotify_2("last").start();

        /*Here Scheduler will start any thread. But once the counter reaches 3, all the other threads will be notified. Therefore, this will
        not be stuck any time.*/
    }
}

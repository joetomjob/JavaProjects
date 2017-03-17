package Threads;

/**
 * Created by Admin on 22-10-2016.
 */
public class Join extends Thread	{
    private String info;
    Join aT1;

    public Join (String info) {
        this.info = info;
    }

    public void run () {
        System.out.println(info + " is running");
        try {
            sleep(10000);
        }
        catch (  InterruptedException e ) {
            System.out.println("Interrupted!");
            try {
                sleep(100);
            } catch (  Exception ee ) {}
        }
        System.out.println(info + ": exit run");
    }

    public static void main (String args []) {
        Join aT1  = new Join("first");

        aT1.start();
        try { sleep(100); } catch (Exception e ) { e .printStackTrace(); }
        System.out.println("j=hi");
        //aT1.interrupt();

        if ( Thread.interrupted() ) /* interrupted is different from isiterrupted. this is main thread. we are not interrupting main thread.
        Therefore this line won't print. */
            System.out.println("A thread got interrupted");
        try {

                aT1.join();
            System.out.println("Got it");
        }
        catch (  InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}

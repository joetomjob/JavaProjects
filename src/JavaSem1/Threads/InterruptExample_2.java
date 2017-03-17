package Threads;

/**
 * Created by Admin on 22-10-2016.
 */
public class InterruptExample_2 extends Thread{
    private String info;
    InterruptExample_2 aT1;

    public InterruptExample_2 (String info) {
        this.info = info;
    }

    public void run () {
        System.out.println(info + " is running");
        try {
            sleep(10000);
        }
        catch (  InterruptedException e ) {
            System.out.println("Interrupted!");
            if ( isInterrupted() )
                System.out.println("yup it's true."); // This line will not be printed because once the interrupt exception is thrown, isinterrupt flag is reset to false
        }
        System.out.println(info + ": exit run");

    }
    public static void main (String args []) {
        InterruptExample_2 aT1  = new InterruptExample_2("first");

        aT1.start();
        System.out.println("interrupt 'first'");
        aT1.interrupt();
    }
}

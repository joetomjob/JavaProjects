package Threads;

public class InterruptExample_1 extends Thread{
    private String name;

    public InterruptExample_1(String name) {
        this.name = name;
    }

    public static void sleepForAbit(long sleepTime )	{
        try {
            sleep(sleepTime);
        } catch (InterruptedException e) {
            System.err.println("Was interrupted in sleepForAbit");
        }

    }
    public void run() {

        System.out.println(name + " has started!");
        double x = 1;
        while ( x > 0 )	{		// forever loop
            x = x * 2 - x;		// x is constant
            System.out.println(x);
            if ( isInterrupted() )	{
                System.out.println(name + "is interrupted");
                break;
            }
        }
        System.out.println(name + " has exited!");
    }

    public static void main(String args[]){

        InterruptExample_1 aThread = new InterruptExample_1("aThread");
        aThread.start();
        sleepForAbit(500);
        System.out.println("j");
        aThread.interrupt();
        System.out.println("i");

    }
}

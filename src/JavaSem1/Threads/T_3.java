package Threads;
/*
 * is this output	--->
 *			<--
 *			...
 * the only possible output?
 * wievele objekte werden benutzt?
 */
public class T_3 extends Thread    {
    private int info;

    public T_3 (int info) {
        this.info    = info;
    }

    public synchronized void run () { /* we cant write static or anything else here because run is a method of thread
    we are just using or overriding it and we cannot modify it*/
        System.err.println("--> " + info);
        try {
            sleep(1000);
        } catch (  Exception e ) {
            e.printStackTrace();
        }
        System.err.println("<-- " + info);
    }

    public static void main (String args []) {
        for ( int i = 1; i < 100; i ++ )
            new T_3(i).start();
        /*each time we are creating a new object. Nothing will be synchrinized*/
    }
}
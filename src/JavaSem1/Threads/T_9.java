package Threads;
/*
 * is this output	1 0 1 0 1 ...
 *			...
 * the only possible output?
 *
 * Falsch: es ist nichtgarantiert, in welcher die
 * Threads eintreten.
 */
public class T_9 extends Thread	{
    private String info;
    static Object o = new Object();
    public T_9 (String info) {
        this.info    = info;
    }
    public void run () {
        synchronized ( o ) {
            while ( true )	{
                System.out.println(info);
                try {
                    o.notify();
                    sleep(100);
                    o.wait();
                    //System.out.println(info);
                } catch ( Exception e ) { }
            }
        }
    }
    public static void main (String args []) {
        ( new T_9("0") ).start();
        ( new T_9("1") ).start();

        /*The output is 10101..... or 01010101......
        * Since while(true) is written, an infinite loop runs.
        * One is waited, other is started, then that goes to wat and the other starts and so on*/
    }
}

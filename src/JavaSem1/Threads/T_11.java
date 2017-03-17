package Threads;

/*
 * is this output	1 0 1 0 1 ...
 *			...
 * the only possible output?
 *
 * Falsch: es ist nichtgarantiert, in welcher die
 * Threads eintreten.
 */
public class T_11 extends Thread	{
    private String info;
    static Object o = new Object();
    public T_11 (String info) {
        this.info    = info;
    }
    public void run () {
        while ( true )	{
            synchronized ( o ) {
                System.out.println(info);
                try {
                    o.notify();
                    sleep(100);
                    o.wait(1);
                } catch ( Exception e ) { }
            }
        }
    }
    public static void main (String args []) {
        ( new T_11("0") ).start();
        ( new T_11("1") ).start();
        /*the outputs are 1010101..... or 0101010101.......*/
    }
}
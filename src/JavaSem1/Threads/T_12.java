package Threads;
/*
 * is this output	0 1 0 1 0 1 ...
 * the only possible output?
 *
 *
 */
public class T_12 extends Thread	{
    private String info;
    static Object o = new Object();

    public T_12 (String info) {
        this.info    = info;
    }
    public void run () {
        while ( true )	{
            synchronized ( o ) {
                o.notify();
                System.out.println(info);
                try {
                    sleep(300);
                    o.wait();
                } catch ( Exception e ) { }
            }
        }
    }
    public static void main (String args []) {
        new T_12("0").start();
        new T_12("1").start();
    }
}
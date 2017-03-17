package Threads;

/*
 * is this output	--->
 *			<--
 *			...
 * the only possible output?
 * nur ein o
 */
public class T_4 extends Thread    {

    static Object o = new Object();
    String info;

    public T_4(String info )    {
        this.info = info;
    }

    public void run () {
        synchronized ( o ) {
            System.err.println("--->" + info);
            try {
                sleep(1000);
            }
            catch (  InterruptedException e ) {
                System.err.println("Interrupted!");
            }
            System.err.println("<---" + info);
        }
    }

    public static void main (String args []) {
        new T_4("1").start();
        new T_4("2").start();
        new T_4("3").start();

        /*Here the synchronization is on object "o". object "o" is static. Therefore all of the objects os T_4 shares the same "o"
        * Therefore all of them are synchronized. If Object "o" was not static, then it would not have been synchronized*/
    }
}
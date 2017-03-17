package Threads;
/*
 * is this output	--->
 *			<--
 *			...
 * the only possible output?
 * ja ein objekt
 */
public class T_2 extends Thread    {
    String info;

    public T_2(String info )	{
        this.info = info;
    }
    private void inProtected () {
        synchronized ( info )       {
            System.err.println("--> " + info);
            try {
                sleep(1000);
            } catch (  Exception e ) {
                e.printStackTrace();
            }
            System.err.println("<-- " + info);
        }
    }

    public void run () {
        inProtected();
    }
    public static void main (String args []) {
        T_2 one = new T_2("a");
        one.start();
        T_2 two = new T_2("a");
        two.start();
        // new T_2("a").start();
        // new T_2("b").start();

        /*Here "a" is a literal. it will be same throughout the program. and here it synchronized with the info. Here for all objects same
        * literal is used. so all are synchronized. If we create a new object and if we call with the literal a, it will be synchronized*/

    }
}
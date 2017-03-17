package Threads;

public class X_2 extends Thread	{
    private static String o1  = new String();
    private static String o2  = new String();
    private String info;

    public X_2 (String info) {
        this.info    = info;
    }
    private void inProtected_1 () {
        synchronized ( o2 )   {
            inProtected_2();
        }
    }
    private void inProtected_2 () {
        synchronized ( o1 )   {
            inProtected_1();
        }
    }
    public void run () {
        if ( info.equals("first") )	{
            synchronized ( o1 )   {
                inProtected_1();
            }
        } else
            synchronized ( o2 )   {
                inProtected_2();
            }
    }
    public static void main (String args []) {
        new X_2("second").start();
        new X_2("first").start();
    }
}
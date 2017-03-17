package Threads;

public class T_10 extends Thread	{
    String info = "";
    public T_10 (String info) {
        this.info    = info;
    }
    public synchronized void run () {
        try {

            while ( true )	{
                System.out.println(info);
                this.notify();
                this.wait();
            }
        } catch ( Exception e )	{}
    }
    public static void main (String args []) {
        new T_10("0").start();
        new T_10("1").start();
        /*Here either 01 is printed or 10 is printed and then the program is stuck It is because, here the method is synchronized and not object
        * Therefore if one goes to wait, nobody is there to notify. Both threads are running independently*/
    }
}
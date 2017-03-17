package Threads;

/*
 * Should print out 0 1 0 1 0 1 ...
 * Is this correct?
 *
 * nicht richtig,
 * weil der Konstruktor fuer das Objekt mit der Id 0
 * nicht zuende gehen muss bevor der 2. Konstruktor
 * zuende geht.
 *
 */
public class T_13 extends Thread	{
    private String info;
    static Object o = new Object();

    public T_13 (String info) {
        this.info    = info;
        synchronized ( o ) {
            if ( info.equals("0"))  /*constructer comes over here . first it is zero. Inside it again constructor is called, but the info changes
                                    to 1. Therefore it wont enter the condition. Therefore there are 2 threads now. one created in main and the other
                                    created over here. Any one can start and the output can be 0101010... ore 101010...*/
                ( new T_13("1") ).start();
        }
    }
    public void run () {
        while ( true )	{
            synchronized ( o ) {
                System.out.println(info);
                try {
                    o.notify();
                    sleep(100);
                    o.wait();
                } catch ( Exception e ) { }
            }
        }
    }
    public static void main (String args []) {
        new T_13("0").start();
        /*both 01010... and 10101.. are possible*/
    }
}
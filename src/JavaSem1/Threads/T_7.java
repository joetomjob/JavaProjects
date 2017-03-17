package Threads;

public class T_7 extends Thread    {
    String i = "2";
    static String  theValue;
    T_7(String i)	{
        this.i = i;
    }
    public void run () {
        synchronized ( theValue )	{
            if ( this.i.equals("1") )
                theValue = "3";
            else
                theValue = "4";
        }
    }

    public static void main (String args []) {
        T_7 aT_7_1 = new T_7("1");
        T_7 aT_7_2 = new T_7("1");
        aT_7_1.start();
        aT_7_2.start();
/* drei threads, es haengt davon up, wann der main
 * thread durch den Block geht
 */
        synchronized ( theValue )	{
            System.out.println("theValue = " + theValue );


            /*Null pointer exception is thrown because here it is synchronized on "theValue". but the value of "theValue" is currently null
            and we cant call synchronized on a null object*/
        }
    }
}
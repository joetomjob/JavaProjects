package Threads;
/*
 * alles ist moeglich
 */
public class T_5 extends Thread    {
    static String i = "2";
    static String  theValue ;
    T_5(String i)	{
        this.i = i;
    }
    public void run () {
        if ( this.i.equals("1") ) /*"this.i" will always be 1. because while creating the object in main function we are calling the constructor
                                    and we are resetting the value of i from 2 to 1 in the beginnig of the main function*/
            theValue = "3";
        else
            theValue = "4";
    }

    public static void main (String args []) {
        T_5 aT_5_a = new T_5("1");
        T_5 aT_5_b = new T_5("1");

        aT_5_a.start();
        aT_5_a.run(); /*.start() and .run() are diffrent. In .start() the scheduler can or cannot go into the run function. But if we call run()
        Then it must go into the run function
        Here .start can call first and thevalue is set to 3. thevalue will not be set to 4 anytime because, in the condition in the run function
        we are checking this.i and this.i is always 1 as we are not changing its value anywhere.
        Therefore the only possible output is 3 and 3*/

        System.out.println("aT_5.i = " + aT_5_b.theValue );
        System.out.println("aT_5.i = " + aT_5_a.theValue );
    }
}

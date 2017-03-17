package Threads;

public class T_6 extends Thread    {
    String i = "2";
    static String  theValue ;
    T_6(String i)	{
        this.i = i;
    }
    public void run () {
        if ( this.i.equals("1") ) /*almost similar to previous problem T_5. value of i doesnt change from 1(it will change from 2 to 1 after
                                    calling the constructor)*/
            theValue = "3";
        else
            theValue = "4";
    }

    /*
     * falls run nichts passiert in paralell
     */
    public static void main (String args []) {
        T_6 aT_6_1 = new T_6("1");
        T_6 aT_6_2 = new T_6("1");
        aT_6_1.start();
        aT_6_2.start();
        System.out.println("the value = " + theValue );
        /*Here there are 2 options
        * 1) both wont start. main thread compeletes execution. Then null is printed
        * 2) then either aT_6_1 or aT_6_1 can start and then main can run and then the remaining thread can run. Then 3 will be printed
        * Otherwise both threads can run. If both the thread runs also, theValue is set to 3 and then main() runs. Then also 3 is printed*/
    }
}

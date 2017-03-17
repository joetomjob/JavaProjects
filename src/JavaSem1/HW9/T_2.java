package HW9;

/**
 * The possible outputs are (0,0)(0,1)(0,2)(0,3)(0,4)(1,1)(1,2)(1,3)(1,4)(2,1)(2,2)(2,3)(2,4)(3,1)(3,2)(3,3)(3,4)
 */
public class T_2 extends Thread    {
    int id = 1;
    static int  theValue  = 0;
    T_2(int id)       {
        this.id = id;
    }
    public void run () {
        theValue = id;
    }

    public static void main (String args []) {
        new T_2(1).start();;
        new T_2(2).start();;
        new T_2(3).start();;

        System.out.println("theValue = " + theValue );
        new T_2(4).start();;
        System.out.println("theValue = " + theValue );
    }
}
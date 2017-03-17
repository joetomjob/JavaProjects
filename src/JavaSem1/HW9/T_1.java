package HW9;

/*The possible outputs are (3,5),(4,5),(5,5)*/
public class T_1 extends Thread	{
    static int x = 1;
    String info = "";

    public T_1 (String info) {
        this.info = info;
        x++;
    }

    public void run () {
        x = ( x >= 1 ? ++x : --x );
        System.out.println(x);
    }

    public static void main (String args []) {
        new T_1("a").start();
        new T_1("b").start();
    }
}

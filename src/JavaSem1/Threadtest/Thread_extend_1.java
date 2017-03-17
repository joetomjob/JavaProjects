package Threadtest;

/**
 * Created by Admin on 22-10-2016.
 */
public class Thread_extend_1 extends Thread{
    private String info;
    static int x = 0;

    public Thread_extend_1(String r ){
        info = r;
    }

    public void run(){
        if(info == "1"){
            x = 3;
        }
        else{
            x = 1;
        }
        System.out.println(x);
    }

    public static void main(String[] args) {
        Thread_extend_1 at1 = new Thread_extend_1("1");
        Thread_extend_1 at2 = new Thread_extend_1("2");

        at1.start();
        at2.start();

        System.out.println(x);
    }

}

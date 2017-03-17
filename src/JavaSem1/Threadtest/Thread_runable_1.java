package Threadtest;

/**
 * Created by Admin on 22-10-2016.
 */
public class Thread_runable_1 implements Runnable{
    private String info;
    static int x = 0;

    public Thread_runable_1(String r ){
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
        Thread_runable_1 at1 = new Thread_runable_1 ("1");
        Thread_runable_1 at2 = new Thread_runable_1 ("2");

        new Thread(at1).start();
        new Thread(at2).start();

        System.out.println(x);
    }
}

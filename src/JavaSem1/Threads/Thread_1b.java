package Threads;

public class Thread_1b implements Runnable {

    private String info;
    int x = 0;

    public Thread_1b (String info) {
        this.info = info;
    }

    public void run () {
        x=1;
        System.out.println(info);
    }

    public static void main (String args []) {
        int j = 0;
        if (j == 0)	{
            for (int n = 0; n < 4; ++ n)	{

                Thread_1b x = new Thread_1b(""+n);
                new Thread(x).start();
                //new Thread( new Thread_1b("" + n ) ).start();
            }
        }
    }
}

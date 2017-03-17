package Threads;

/**
 * Created by Admin on 23-10-2016.
 */
public class Join_2 extends Thread{
    public void run(){
        System.out.println("---->");
        //               try { sleep(1000000); } catch (  InterruptedException e ) { }
        System.out.println("<----");
    }
    public void multiply(){
        for(int i = 0; i < 10; i++){
            for(int j =0; j < 10; j++){
                Join_2 et = new Join_2();
                //Thread et = new Join_2();
                /* same as Join_2 et = new Join_2() because Thread is the parent class and the instance created
                is of Join_2*/
                et.start();

				try{
					et.join(); //output : only one combination.    // go forward only after completing et
				}
				catch(InterruptedException e){
					System.out.println("Interrupted!");
				}

            }
        }
    }
    public static void main(String[] args) {
        Join_2 eval = new Join_2();
        eval.multiply();
    }
}

package testing;

/**
 * Created by Admin on 26-02-2017.
 */
class base{
    public static void main(String[] args) {
        mathworks m = new mathworks();
        m.print();
        System.out.println("JOe")  ;
    }

}
public class mathworks extends base{
    public void print(){
        System.out.println("Yo");
    }
}

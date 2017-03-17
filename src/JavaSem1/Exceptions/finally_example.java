package Exceptions;

/**
 * Created by Admin on 27-10-2016.
 */
public class finally_example {
    public static void main(String[] args) {
        try{
            System.out.println("hi");
            int k = 1/0;
            System.out.println("hoi");
        }
        catch (Exception e){
            System.out.println("I am not there");

        }
        finally {
            System.out.println("I am there");
        }

    }
}

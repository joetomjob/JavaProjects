package Exceptions;

public class StQu1	{

    /*
    http://download.oracle.com/javase/tutorial/essential/exceptions/finally.html
    */
    public int tryCatchFinally() {
        try {
            try {
                System.out.println("Inner TRY");
                int i = 1/0;
                System.out.println("Inner TRY after 1/0");
                return 1;
            } catch (Exception e) {
                System.out.println("Inner CATCH");
                int i = 1/0;
                System.out.println("Inner CATCH after 1/0");
                return 2;
            } finally {
                System.out.println("Inner FINALLY!");
                //int i = 1/0;
                // System.exit(1);
                //return 3;	// what will happen if we comment this line out?
            }
        } catch (Exception e) {
            System.out.println("Outer Catch");
            return 4;
        } finally {
            System.out.println("Outer FINALLY");
            //System.exit(1);	// hat will happen if we comment this line out?
            return 6;	// what will happen if we comment this line out?
        }
    }


    public static void main(String[] args )	{
        // return value is?
        System.out.println("new StQu1().tryCatchFinally(); = " +
                new StQu1().tryCatchFinally() );
        //finally>return>catch
        //even if a return is called, it will come out of the function only after going to finally
    }
}

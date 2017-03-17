package Threads;

public class X_1 {

    private void caller()	 {
        try {
            throw new NumberFormatException("not good");
        } catch (Exception e)	{
            e.printStackTrace();
        } finally	{
            System.out.println("a");
        }
    }
    private void exit()	 {
        try {
            caller();
            throw new NumberFormatException("not good 2");
        } catch (NumberFormatException e)	{
            System.out.println("b");
            return;
        } catch (Exception e)	{
            System.out.println("c");
            return;
        } finally	{
            System.out.println("d");
        }
    }

    public static void main(String[] args) {
        new X_1().exit();
    }
}
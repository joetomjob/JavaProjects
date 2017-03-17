import java.util.Scanner;
import java.util.Vector;
class S3 {

    public int instanceV = 1;

    public void set(int value)	{
        instanceV = value;
    }
    public String toString()	{
        return "S3: " + instanceV;
    }

    public static void main(String args[]) {
        System.out.println(new S3());
    }
}
public class X_4 extends S3 {

    public int instanceV = 4;

    public void onlyInS4()	{
        System.out.println("S4: onlyInS4");
    }
    public void set(int value)    {
        instanceV = value;
    }
    public String toString()      {
        return "S4: " + instanceV;
    }

    public static void main(String args[]) {
        X_4 aS4 = new X_4();
        S3 aS3 = (S3)aS4;

        System.out.println("aS4 =" + aS4 );
        System.out.println("aS4.instanceV = " + aS4.instanceV );

        System.out.println("aS3 =" + aS3 );
        System.out.println("aS3.instanceV = " + aS3.instanceV );

        System.out.println("S4.set(44);");
        System.out.println("S3.set(33);");
        aS4.set(44);
        aS3.set(33);

        System.out.println("aS4 =" + aS4 );
        System.out.println("aS4.instanceV =" + aS4.instanceV );

        System.out.println("aS3 =" + aS3 );
        System.out.println("aS3.instanceV =" + aS3.instanceV );
    }
}

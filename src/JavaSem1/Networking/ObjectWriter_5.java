package Networking;
import java.io.*;
import java.util.Date;

public class ObjectWriter_5 {
    public static void main( String args[] ) {
        try {
            FileOutputStream ostream = new FileOutputStream("object_5.data");
            ObjectOutputStream p = new ObjectOutputStream(ostream);
            p.writeObject("User: " + "hpb");
            p.close();
        }
        catch ( IOException e)	{
            System.out.println(e.getMessage());
        }
    }
}

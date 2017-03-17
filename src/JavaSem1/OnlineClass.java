import org.omg.CORBA.portable.InputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class OnlineClass {
    public static void main(String[] args) throws Exception{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(b.readLine());

        URL x = new URL("www.google.com");
//        InputStream y = x.openStream();
//        InputStreamReader z = new InputStreamReader(y);
//        BufferedReader a = new BufferedReader(z);
//        System.out.println(a.readLine());
    }
}


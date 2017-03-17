package Networking;
/**
 * Created by Rao on 11/7/2016.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Old_Client {
    public static void main(String[] args) throws IOException {
        int number,temp;
        Scanner sc1 = new Scanner(System.in);
        Socket s1 = new Socket("localhost",12345);
        Scanner sc2 = new Scanner(s1.getInputStream());
        System.out.println("Enter a integer");
        number = sc1.nextInt();
        PrintStream p = new PrintStream(s1.getOutputStream());
        p.println(number);

        temp=sc2.nextInt();
        System.out.println(temp);


    }





}


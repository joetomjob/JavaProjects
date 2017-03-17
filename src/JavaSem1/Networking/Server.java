package Networking;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
    public static void main(String args[]) throws Exception
    {
        int number,temp;
        ServerSocket s2 = new ServerSocket(12345);
        Socket ss = s2.accept();
        Scanner sc3 = new Scanner(ss.getInputStream());
        number = sc3.nextInt();

        temp = number*2;
        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println(temp);

    }
}
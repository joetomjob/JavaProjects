package Networking;
import java.net.*;
import java.io.*;

public class UDP{

	public static void main(String arg[]) throws Exception
	{
	DatagramSocket ds= new DatagramSocket();
	byte [] b= "Hello".getBytes();
	
	InetAddress ip =InetAddress.getByName("localhost");
	int port=12345;
	
	
	
	DatagramPacket dp = new DatagramPacket (b,b.length,ip,12345 );
	
	ds.send(dp);
	}

}
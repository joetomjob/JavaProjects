package BattleShipUDP;
import java.io.*;
import java.net.*;

public class BattleShipClient1 {

    public static void main(String[] args) throws Exception{


        String soce = new String();
        byte[] b = soce.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        int port =12345;
        DatagramPacket dp = new DatagramPacket(b,b.length,ip,port);
        DatagramSocket soc = new DatagramSocket(port);
        soc.receive(dp);
        soc.send(dp);

        String data_to_be_sent ="";
        String data_received ="";

        while(true){

        }
    }
}

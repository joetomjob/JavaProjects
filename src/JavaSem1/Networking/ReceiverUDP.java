package Networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiverUDP {
    public static void main(String[] args) {
        try {
            int port = 90;
            DatagramSocket dsocket = new DatagramSocket(port);
            byte[] buffer = new byte[2048];

            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

            while(true){
                dsocket.receive(packet);
                String message = new String(buffer,0,packet.getLength());
                System.out.println(packet.getAddress().getHostName()+": "+message);

                packet.setLength(buffer.length);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

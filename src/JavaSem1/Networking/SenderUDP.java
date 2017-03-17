package Networking;

import java.net.*;
import java.net.InetAddress;

/**
 * Created by Admin on 06-11-2016.
 */
public class SenderUDP {


    public static void main(String[] args) {
        //ipv4 =  129.21.101.103
        byte[] buffer = new byte[65508];
        try {
            int port = 9719;
            InetAddress address = InetAddress.getByName("129.21.101.103");
            byte[] message = "Java Source and Support".getBytes();

            DatagramPacket packet = new DatagramPacket(message, message.length, address, port);

            DatagramSocket dsocket = new DatagramSocket();
            dsocket.send(packet);
            dsocket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }





}

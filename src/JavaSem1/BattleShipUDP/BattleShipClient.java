package BattleShipUDP;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class BattleShipClient {

    public static void main(String[] args) throws Exception {
        int port = 9862;
        InetAddress address = InetAddress.getByName("localhost");
        DatagramSocket dsocket = new DatagramSocket(port);
        byte[] buffer = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        while (true) {

                dsocket.receive(packet);
                String message = new String(buffer,0,packet.getLength());

                InputView inputView = new InputView();
                OutputView outputView = new OutputView();

                if (message.equals("~")||message.equals("B")||message.equals("C")||message.equals("D")||
                        message.equals("A")||message.equals("\t")||message.equals("\n")||message.equals("H")||message.equals("m"))
                {
                    outputView.outputChar(message);
                }
                else {
                    outputView.outputValue(message);
                }
                if (message.equals("player A Wins") || message.equals("player B Wins") || message.equals("Minimum value cannot be less than zero")) // Break from infinite while loop
                    break;
                packet.setLength(buffer.length);
            }
        }

    }

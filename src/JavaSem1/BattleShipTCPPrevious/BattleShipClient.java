package BattleShipTCPPrevious;

import BattleShip11.View.*;

import java.io.*;
import java.net.Socket;

class BattleShipClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8909);
        DataInputStream getdata = new DataInputStream(socket.getInputStream());
        DataOutputStream senddata = new DataOutputStream(socket.getOutputStream());
        BufferedReader data_reader = new BufferedReader(new InputStreamReader(System.in));

        String data_to_be_sent = "";
        String data_received = "";

        while (true) {
            do {
                InputView inputView = new InputView();
                OutputView outputView = new OutputView();
                data_received = getdata.readUTF();
                if (data_received.equals("~")||data_received.equals("B")||data_received.equals("C")||data_received.equals("D")||
                        data_received.equals("A")||data_received.equals("\t")||data_received.equals("\n")||data_received.equals("H")||data_received.equals("m"))
                {
                    outputView.outputChar(data_received);
                }
                else {
                    outputView.outputValue(data_received);
                }

            } while (getdata.readBoolean());

            if (data_received.equals("player A Wins") || data_received.equals("player B Wins") || data_received.equals("Minimum value cannot be less than zero"))
                break;

            data_to_be_sent = data_reader.readLine();
            senddata.writeUTF(data_to_be_sent);
            senddata.flush();
        }
        getdata.close();
        senddata.close();
        data_reader.close();
        socket.close();
    }
}
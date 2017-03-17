package BattleShipTCP;


import java.io.*;
import java.net.Socket;


class BattleShipClient implements Serializable {
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8909);
        DataInputStream getdata = new DataInputStream(socket.getInputStream());
        DataOutputStream senddata = new DataOutputStream(socket.getOutputStream());
        BufferedReader data_reader = new BufferedReader(new InputStreamReader(System.in));

        String data_to_be_sent = "";
        String data_received = "";

        data_received = getdata.readUTF();
        if (data_received.equals("Server Starts the play")){
            int minrow = 0;
            int mincol = 0;
            int maxrow = 10;
            int maxcol = 10;
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());


            Ocean aOcean = new Ocean(minrow, mincol, maxrow, maxcol, dataInputStream, dataOutputStream);
//            Ocean bOcean = new Ocean(minrow, mincol, maxrow, maxcol, dataInputStream, dataOutputStream);

            Player playerA = new Player(aOcean, "player A", 'H', 'm');
//            Player playerB = new Player(bOcean, "player B", 'H', 'm');

            Fleet fleetA = new Fleet(dataInputStream, dataOutputStream);
//            Fleet fleetB = new Fleet(dataInputStream, dataOutputStream);

            playerA = fleetA.createTheFleet(playerA, playerA.player);
//            playerB = fleetB.createTheFleet(playerB, playerB.player);

            aOcean.DisplaytheOcean(playerA.o, playerA.player);
            //dataOutputStream.("Server Starts the play");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(playerA);

//            bOcean.DisplaytheOcean(playerB.o, playerB.player);
        }
    }
}
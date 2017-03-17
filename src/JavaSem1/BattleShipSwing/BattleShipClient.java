package BattleShipSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BattleShipClient implements BattleShipClientInterface, Serializable {

    public static BattleShipClientInterface battleStub;

    public static String host = "localhost";
    public static Registry registry;
    public static BattleShipServerInterface serverResponse;

    //region Components for the panel
    public static JFrame frame = new JFrame("BattleShipGamePlayer1");
    public static JPanel pnlBattleShipGame = new JPanel();


    public static JButton btnStartServer = new JButton("Connect with the Server");
    public static JButton btnStopServer = new JButton("Stop the Game");

    //region Name of Player
    public static JLabel lblPlayerName = new JLabel("Player B");
    public static JTextField txtPlayerName = new JTextField();
    public static JButton btnAssignName = new JButton("Assign name to player");
    //endregion

    //region Rows and columns
    public static JLabel lblMaxRow = new JLabel("Number of rows");
    public static JTextField txtMaxRow = new JTextField();
    public static JLabel lblMaxCol = new JLabel("Number of columns");
    public static JTextField txtMaxCol = new JTextField();
    //endregion

    //region Enter the co-ordinates and position of the ship
    public static JLabel lblXCord = new JLabel("Enter X-Coordinate");
    public static JLabel lblYCord = new JLabel("Enter Y-Coordinate");
    public static JLabel lblPos = new JLabel("Enter the position(v/h)");

    public static JTextField txtXCord = new JTextField();
    public static JTextField txtYCord = new JTextField();
    public static JTextField txtPos = new JTextField();

    public static JButton btnPlaceShip = new JButton("Place the Ship");
    //endregion

    //region components for playing the game
    public static JLabel lblXofShip = new JLabel("Enter X-Coordinate of ship");
    public static JLabel lblYofShip = new JLabel("Enter Y-Coordinate of ship");

    public static JTextField txtXofShip = new JTextField();
    public static JTextField txtYofShip = new JTextField();

    public static JButton btnHitOrMiss = new JButton("Hit or Miss");
    //endregion

    //region ErrorMessage
    public static JLabel lblErrorMessage = new JLabel();
    //endregion
    public static JLabel[][] panelOcean;
    public static JLabel[][] panelOcean2;
    //endregion

    public static Ocean bOcean;
    public static Player playerB;
    public static Player playerA;
    public static Fleet fleetB;

    public static Ocean pla;
    public static Ocean plb;

    public static int minrow = 0;
    public static int mincol = 0;
    public static int maxrow = 15;
    public static int maxcol = 15;

    @Override
    public Player rmiGame(int row, int col) throws RemoteException {

        lblErrorMessage.setText("Please enter the Name of the player");
        btnAssignName.setEnabled(true);

        maxrow = row;
        maxcol = col;

        txtMaxRow.setText(String.valueOf(maxrow));
        txtMaxCol.setText(String.valueOf(maxcol));

        txtMaxRow.setEnabled(false);
        txtMaxCol.setEnabled(false);

        bOcean = new Ocean(minrow, mincol, maxrow, maxcol);
        playerB = new Player(bOcean, "player B", 'H', 'm');
        fleetB = new Fleet();
        return playerB;
    }

    @Override
    public void stopFunction(String string) throws RemoteException {
        lblErrorMessage.setText(string);
        enableDisableButtons(false);
        //System.exit(0);
    }

    @Override
    public void stopGame() throws RemoteException {
        System.exit(0);
    }

    @Override
    public void playTheGame(Player a, Player b, Ocean oceana, Ocean oceanb) throws RemoteException {

        btnHitOrMiss.setEnabled(true);

        playerA = a;
        playerB = b;

        if (oceana == null) {
            pla = new Ocean(0, 0, playerA.o.maxrow, playerA.o.maxcol);
        } else {
            pla = oceana;
        }
        if (oceanb == null) {
            plb = new Ocean(0, 0, playerB.o.maxrow, playerB.o.maxcol);
        } else {
            plb = oceanb;
        }


    }

    public static Component createComponents() {

        JPanel mainPane = new JPanel();
        mainPane.setBorder(BorderFactory.createLoweredBevelBorder());
        mainPane.setLayout(new GridLayout(3, 1));

        JPanel topPane = new JPanel();
        topPane.setBorder(BorderFactory.createLoweredBevelBorder());
        topPane.setLayout(new GridLayout(7, 1));

        JPanel middlePane = new JPanel();
        middlePane.setBorder(BorderFactory.createLoweredBevelBorder());
        middlePane.setLayout(new GridLayout(maxrow, maxcol));

        JPanel bottomPane = new JPanel();
        bottomPane.setBorder(BorderFactory.createLoweredBevelBorder());
        bottomPane.setLayout(new GridLayout(maxrow, maxcol));

        JPanel firstPane = new JPanel();
        firstPane.setBorder(BorderFactory.createLoweredBevelBorder());
        firstPane.setLayout(new GridLayout(1, 3));

        JPanel secondPane = new JPanel();
        secondPane.setBorder(BorderFactory.createLoweredBevelBorder());
        secondPane.setLayout(new GridLayout(1, 7));

        JPanel thirdPane = new JPanel();
        thirdPane.setBorder(BorderFactory.createLoweredBevelBorder());
        thirdPane.setLayout(new GridLayout(1, 5));

        JPanel fourthPane = new JPanel();
        fourthPane.setBorder(BorderFactory.createLoweredBevelBorder());
        fourthPane.setLayout(new GridLayout(1, 1));

        JPanel fifthPane = new JPanel();
        fifthPane.setBorder(BorderFactory.createLoweredBevelBorder());
        fifthPane.setLayout(new GridLayout(1, 1));

        JPanel sixthPane = new JPanel();
        sixthPane.setBorder(BorderFactory.createLoweredBevelBorder());
        sixthPane.setLayout(new GridLayout(1, 1));

        JPanel seventhPane = new JPanel();
        seventhPane.setBorder(BorderFactory.createLoweredBevelBorder());
        seventhPane.setLayout(new GridLayout(1, 4));

        firstPane.add(lblPlayerName);
        firstPane.add(txtPlayerName);
        firstPane.add(btnAssignName);

        secondPane.add(lblXCord);
        secondPane.add(txtXCord);
        secondPane.add(lblYCord);
        secondPane.add(txtYCord);
        secondPane.add(lblPos);
        secondPane.add(txtPos);
        secondPane.add(btnPlaceShip);

        thirdPane.add(lblXofShip);
        thirdPane.add(txtXofShip);
        thirdPane.add(lblYofShip);
        thirdPane.add(txtYofShip);
        thirdPane.add(btnHitOrMiss);

        fourthPane.add(lblErrorMessage);

        fifthPane.add(btnStartServer);

        sixthPane.add(btnStopServer);

        seventhPane.add(lblMaxRow);
        seventhPane.add(txtMaxRow);
        seventhPane.add(lblMaxCol);
        seventhPane.add(txtMaxCol);

        topPane.add(fifthPane);
        topPane.add(firstPane);
        topPane.add(seventhPane);
        topPane.add(secondPane);
        topPane.add(thirdPane);
        topPane.add(fourthPane);
        topPane.add(sixthPane);


        panelOcean = new JLabel[maxrow][maxcol];
        for (int i = 0; i < maxrow; i++) {
            for (int j = 0; j < maxcol; j++) {
                panelOcean[i][j] = new JLabel();
                //panelOcean[i][j].setText("j");
                middlePane.add(panelOcean[i][j]);
            }
        }
        panelOcean2 = new JLabel[maxrow][maxcol];
        for (int i = 0; i < maxrow; i++) {
            for (int j = 0; j < maxcol; j++) {
                panelOcean2[i][j] = new JLabel();
                //panelOcean2[i][j].setText("k");
                bottomPane.add(panelOcean2[i][j]);
            }
        }

        mainPane.add(topPane);
        mainPane.add(middlePane);
        mainPane.add(bottomPane);

        return mainPane;
    }

    private static void createAndShowGUI() {

        //region Setting up the look and feel for the region
        String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
        }
        //endregion

        JFrame frame = new JFrame("BattleShipGamePlayer2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Component contents = createComponents();
        frame.getContentPane().add(contents);

        //Display the window.
        InputMap im = btnAssignName.getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");

        InputMap im3 = btnPlaceShip.getInputMap();
        im3.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im3.put(KeyStroke.getKeyStroke("released ENTER"), "released");

        InputMap im4 = btnHitOrMiss.getInputMap();
        im4.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im4.put(KeyStroke.getKeyStroke("released ENTER"), "released");

        frame.setMinimumSize(new Dimension(900,600));
        frame.pack();
        frame.setVisible(true);
    }

    public static void ActionListners() {
        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTheClient();
            }
        });

        btnPlaceShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xcord, ycord;
                if (fleetB.battleShip.orientation == null || fleetB.battleShip.orientation.isEmpty()) {
                    try {
                        xcord = txtXCord.getText();
                        fleetB.battleShip.xCoordinate = Integer.parseInt(xcord);

                        ycord = txtYCord.getText();
                        fleetB.battleShip.yCoordinate = Integer.parseInt(ycord);

                        fleetB.battleShip.orientation = txtPos.getText();
                        fleetB.battleShip.shipLength = 4;

                    } catch (Exception ex) {
                        lblErrorMessage.setText("Enter Integer value");
                    }
                    if (fleetB.battleShip.orientation != null && !fleetB.battleShip.orientation.isEmpty()) {
                        if (fleetB.battleShip.xCoordinate >= playerB.o.minrow && fleetB.battleShip.xCoordinate < playerB.o.maxrow && fleetB.battleShip.yCoordinate >= playerB.o.mincol && fleetB.battleShip.yCoordinate < playerB.o.maxcol) {
                            char mm = playerB.o.oc[fleetB.battleShip.xCoordinate][fleetB.battleShip.yCoordinate]; //This is saved to check whether the matrix has changed.
                            playerB.spo = CreateShip(playerB.o, fleetB.battleShip.xCoordinate, fleetB.battleShip.yCoordinate, fleetB.battleShip.orientation, fleetB.battleShip.battleShip, fleetB.battleShip.shipLength);// Create the ship with the parameters provided
                            if (playerB.spo.oc[fleetB.battleShip.xCoordinate][fleetB.battleShip.yCoordinate] == mm) { // Move forward only if the matrix is changed
                                fleetB.battleShip.orientation = null;
                            } else {
                                lblErrorMessage.setText("Battle Ship is placed");
                                for (int i = 0; i < maxrow; i++) {
                                    for (int j = 0; j < maxcol; j++) {
                                        panelOcean[i][j].setText(String.valueOf(playerB.o.oc[i][j]));
                                    }
                                }
                            }
                        } else {
                            fleetB.battleShip.orientation = null;
                            lblErrorMessage.setText("Invalid input");
                        }
                    }

                } else if (fleetB.carrierShip.orientation == null || fleetB.carrierShip.orientation.isEmpty()) {
                    try {
                        xcord = txtXCord.getText();
                        fleetB.carrierShip.xCoordinate = Integer.parseInt(xcord);

                        ycord = txtYCord.getText();
                        fleetB.carrierShip.yCoordinate = Integer.parseInt(ycord);

                        fleetB.carrierShip.orientation = txtPos.getText();
                        fleetB.carrierShip.shipLength = 3;

                    } catch (Exception ex) {
                        lblErrorMessage.setText("Enter Integer value");
                    }
                    if (fleetB.carrierShip.orientation != null && !fleetB.carrierShip.orientation.isEmpty()) {
                        if (fleetB.carrierShip.xCoordinate >= playerB.o.minrow && fleetB.carrierShip.xCoordinate < playerB.o.maxrow && fleetB.carrierShip.yCoordinate >= playerB.o.mincol && fleetB.carrierShip.yCoordinate < playerB.o.maxcol) {
                            char mm = playerB.o.oc[fleetB.carrierShip.xCoordinate][fleetB.carrierShip.yCoordinate]; //This is saved to check whether the matrix has changed.
                            playerB.spo = CreateShip(playerB.o, fleetB.carrierShip.xCoordinate, fleetB.carrierShip.yCoordinate, fleetB.carrierShip.orientation, fleetB.carrierShip.carrierShip, fleetB.carrierShip.shipLength);// Create the ship with the parameters provided
                            if (playerB.spo.oc[fleetB.carrierShip.xCoordinate][fleetB.carrierShip.yCoordinate] == mm) { // Move forward only if the matrix is changed
                                fleetB.carrierShip.orientation = null;
                            } else {
                                lblErrorMessage.setText("Carrier Ship is placed");
                                for (int i = 0; i < maxrow; i++) {
                                    for (int j = 0; j < maxcol; j++) {
                                        panelOcean[i][j].setText(String.valueOf(playerB.o.oc[i][j]));
                                    }
                                }
                            }
                        } else {
                            fleetB.carrierShip.orientation = null;
                            lblErrorMessage.setText("Invalid input");
                        }
                    }
                } else if (fleetB.destroyerShip.orientation == null || fleetB.destroyerShip.orientation.isEmpty()) {
                    try {
                        xcord = txtXCord.getText();
                        fleetB.destroyerShip.xCoordinate = Integer.parseInt(xcord);

                        ycord = txtYCord.getText();
                        fleetB.destroyerShip.yCoordinate = Integer.parseInt(ycord);

                        fleetB.destroyerShip.orientation = txtPos.getText();
                        fleetB.destroyerShip.shipLength = 2;

                    } catch (Exception ex) {
                        lblErrorMessage.setText("Enter Integer value");
                    }
                    if (fleetB.destroyerShip.orientation != null && !fleetB.destroyerShip.orientation.isEmpty()) {
                        if (fleetB.destroyerShip.xCoordinate >= playerB.o.minrow && fleetB.destroyerShip.xCoordinate < playerB.o.maxrow && fleetB.destroyerShip.yCoordinate >= playerB.o.mincol && fleetB.destroyerShip.yCoordinate < playerB.o.maxcol) {
                            char mm = playerB.o.oc[fleetB.destroyerShip.xCoordinate][fleetB.destroyerShip.yCoordinate]; //This is saved to check whether the matrix has changed.
                            playerB.spo = CreateShip(playerB.o, fleetB.destroyerShip.xCoordinate, fleetB.destroyerShip.yCoordinate, fleetB.destroyerShip.orientation, fleetB.destroyerShip.destroyerShip, fleetB.destroyerShip.shipLength);// Create the ship with the parameters provided
                            if (playerB.spo.oc[fleetB.destroyerShip.xCoordinate][fleetB.destroyerShip.yCoordinate] == mm) { // Move forward only if the matrix is changed
                                fleetB.destroyerShip.orientation = null;
                            } else {
                                lblErrorMessage.setText("Destroyer Ship is placed");
                                for (int i = 0; i < maxrow; i++) {
                                    for (int j = 0; j < maxcol; j++) {
                                        panelOcean[i][j].setText(String.valueOf(playerB.o.oc[i][j]));
                                    }
                                }
                            }
                        } else {
                            fleetB.destroyerShip.orientation = null;
                            lblErrorMessage.setText("Invalid input");
                        }
                    }
                } else if (fleetB.aircraftShip.orientation == null || fleetB.aircraftShip.orientation.isEmpty()) {
                    try {
                        xcord = txtXCord.getText();
                        fleetB.aircraftShip.xCoordinate = Integer.parseInt(xcord);

                        ycord = txtYCord.getText();
                        fleetB.aircraftShip.yCoordinate = Integer.parseInt(ycord);

                        fleetB.aircraftShip.orientation = txtPos.getText();
                        fleetB.aircraftShip.shipLength = 2;

                    } catch (Exception ex) {
                        lblErrorMessage.setText("Enter Integer value");
                    }
                    if (fleetB.aircraftShip.orientation != null && !fleetB.aircraftShip.orientation.isEmpty()) {
                        if (fleetB.aircraftShip.xCoordinate >= playerB.o.minrow && fleetB.aircraftShip.xCoordinate < playerB.o.maxrow && fleetB.aircraftShip.yCoordinate >= playerB.o.mincol && fleetB.aircraftShip.yCoordinate < playerB.o.maxcol) {
                            char mm = playerB.o.oc[fleetB.aircraftShip.xCoordinate][fleetB.aircraftShip.yCoordinate]; //This is saved to check whether the matrix has changed.
                            playerB.spo = CreateShip(playerB.o, fleetB.aircraftShip.xCoordinate, fleetB.aircraftShip.yCoordinate, fleetB.aircraftShip.orientation, fleetB.aircraftShip.aircraftShip, fleetB.aircraftShip.shipLength);// Create the ship with the parameters provided
                            if (playerB.spo.oc[fleetB.aircraftShip.xCoordinate][fleetB.aircraftShip.yCoordinate] == mm) { // Move forward only if the matrix is changed
                                fleetB.aircraftShip.orientation = null;
                            } else {
                                lblErrorMessage.setText("Aircraft Ship is placed. Handed over to next player");
                                txtXCord.setEnabled(false);
                                txtYCord.setEnabled(false);
                                txtPos.setEnabled(false);
                                btnPlaceShip.setEnabled(false);
                                for (int i = 0; i < maxrow; i++) {
                                    for (int j = 0; j < maxcol; j++) {
                                        panelOcean[i][j].setText(String.valueOf(playerB.o.oc[i][j]));
                                    }
                                }
                                try {
                                    serverResponse.playTheGame(battleStub, playerA, playerB, pla, plb);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } else {
                            fleetB.aircraftShip.orientation = null;
                            lblErrorMessage.setText("Invalid input");
                        }
                    }
                }
            }
        });

        btnAssignName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtPlayerName.getText() != null && !txtPlayerName.getText().trim().isEmpty()){
                    playerB.player = txtPlayerName.getText();
                    lblPlayerName.setText(txtPlayerName.getText());
                    btnAssignName.setEnabled(false);
                    btnPlaceShip.setEnabled(true);
                    txtPlayerName.setEnabled(false);
                    lblErrorMessage.setText("Please enter the size of the ocean");
                }
                else{
                    lblErrorMessage.setText("Please enter valid Name");
                }
            }
        });

        btnHitOrMiss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Below objects for ocean is used to display the Hits and misses to the players
                int counterb = 0;

                String xcord, ycord;
                int x = -1, y = -1;

                xcord = txtXofShip.getText();
                ycord = txtYofShip.getText();

                if (xcord.matches("\\d+") && ycord.matches("\\d+")) {
                    x = Integer.parseInt(xcord);
                    y = Integer.parseInt(ycord);
                } else {
                    lblErrorMessage.setText("Please enter Integer values");
                }

                if (x < playerA.o.maxrow && x < playerA.o.maxcol && x >= playerA.o.minrow && x >= playerA.o.mincol) {
                    if (playerA.o.oc[x][y] == '~') {
                        playerA.o.oc[x][y] = playerA.Miss;
                        plb.oc[x][y] = playerA.Miss;

                        //Used to save a miss
                        //plb.DisplaytheOcean(plb, playerA.player);
                        for (int i = 0; i < maxrow; i++) {
                            for (int j = 0; j < maxcol; j++) {
                                panelOcean2[i][j].setText(String.valueOf(plb.oc[i][j]));
                            }
                        }
                        lblErrorMessage.setText("That was a miss. Handed over to next player");
                        try {
                            btnHitOrMiss.setEnabled(false);
                            serverResponse.playTheGame(battleStub, playerA, playerB, pla, plb);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    } else if (playerA.o.oc[x][y] == playerA.Miss || playerA.o.oc[x][y] == playerA.Hit) {

                        lblErrorMessage.setText("This coordinates were supplied earlier.Handed over to next player");
                        try {
                            btnHitOrMiss.setEnabled(false);
                            serverResponse.playTheGame(battleStub, playerA, playerB, pla, plb);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    } else {
                        //Used to save a hit
                        playerA.o.oc[x][y] = playerA.Hit;
                        plb.oc[x][y] = playerA.Hit;
                        lblErrorMessage.setText("That was a Hit.");

                        for (int i = 0; i < maxrow; i++) {
                            for (int j = 0; j < maxcol; j++) {
                                panelOcean2[i][j].setText(String.valueOf(plb.oc[i][j]));
                            }
                        }

                    }
                    //This loop is used to increment the counter. The total number of coordinates used by ships are 10(4+3+2+1)
                    counterb = 0;
                    for (int l = 0; l < playerB.o.maxrow; l++) {
                        for (int m = 0; m < playerB.o.maxcol; m++) {
                            if (playerA.o.oc[l][m] == playerA.Hit) {
                                counterb++;
                            }
                        }
                    }
                    //checks whether all ships are down. If all ships of one player are down, the opponent player wins
                    if (counterb == 11) {
                        lblErrorMessage.setText("You Won the game");

                        try {
                            enableDisableButtons(false);
                            serverResponse.stopFunction(battleStub, playerB.player + " Wins. You Lose");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        //System.exit(0);
                    }
                } else {
                    lblErrorMessage.setText("Invalid Input");
                }


            }
        });

        btnStopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //registry.unbind("BattleShipServerInterface");
                    serverResponse.stopGame();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

    }

    public static void startTheClient() {
        try {
            BattleShipClient battleClient = new BattleShipClient();
            battleStub = (BattleShipClientInterface) UnicastRemoteObject.exportObject(battleClient, 0);

            registry = LocateRegistry.getRegistry(8172);
            serverResponse = (BattleShipServerInterface) registry.lookup("BattleShipServerInterface");
            lblErrorMessage.setText("Server starts the game");
            serverResponse.rmiGame(battleStub);

        } catch (Exception e) {

            e.printStackTrace();
        }
        btnStartServer.setEnabled(false);
    }

    public static void enableDisableButtons(boolean flag) {
        if (!flag) {
            btnAssignName.setEnabled(false);
            btnPlaceShip.setEnabled(false);
            btnHitOrMiss.setEnabled(false);
        } else {
            btnAssignName.setEnabled(true);
            btnPlaceShip.setEnabled(true);
            btnHitOrMiss.setEnabled(true);

        }
    }

    public static Ocean CreateShip(Ocean n, int x, int y, String p, char b, int len) {

        BattleShipView output = new BattleShipView();
        Ocean dd = n;
        if (p.equals("v")) {
            if (x + (len - 1) < n.maxrow && y < n.maxcol) {
                for (int k = 0; k < len; k++) {
                    if (dd.oc[x + k][y] == '~') {
                        dd.oc[x + k][y] = b;
                    } else {
                        lblErrorMessage.setText("You cant put Ship over here. Please enter other value");
                        return n;
                    }
                }
            }
        } else if (p.equals("h")) {
            if (x < n.maxrow && y + (len - 1) < n.maxcol) {
                for (int k = 0; k < len; k++) {
                    if (dd.oc[x][y + k] == '~') {
                        dd.oc[x][y + k] = b;
                    } else {
                        lblErrorMessage.setText("You cant put Ship over here. Please enter other value");
                        return n;
                    }
                }
            }
        } else {
            lblErrorMessage.setText("You entered an incorrect orientation");
            return n;
        }

        return dd;
    }

    public static void main(String[] args) throws Exception {

        //createAndShowGUI();
        createAndShowGUI();
        enableDisableButtons(false);
        ActionListners();

        //region test


    }
}

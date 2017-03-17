package BattleShipSwing;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//This class is used to create the fleet. All the 4 ships are placed using this class

public class BattleShip extends Fleet implements BattleShipServerInterface, Serializable {

    //region Components for the panel
    public static JFrame frame = new JFrame("BattleShipGamePlayer1");
    public static JPanel pnlBattleShipGame = new JPanel();


    public static JButton btnStartServer = new JButton("Start the Server");
    public static JButton btnStopServer = new JButton("Stop the Game");

    //region Name of Player
    public static JLabel lblPlayerName = new JLabel("Player A");
    public static JTextField txtPlayerName = new JTextField();
    public static JButton btnAssignName = new JButton("Assign name to player");
    //endregion

    //region Rows and columns
    public static JLabel lblMaxRow = new JLabel("Enter the number of rows");
    public static JTextField txtMaxRow = new JTextField();
    public static JLabel lblMaxCol = new JLabel("Enter the number of columns");
    public static JTextField txtMaxCol = new JTextField();
    public static JButton btnAssignRowandCol = new JButton("Give the size of the ocean");
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

    public static int minrow = 0;
    public static int mincol = 0;
    public static int maxrow = 15;
    public static int maxcol = 15;

    public static Ocean aOcean;
    public static Player playerA;
    public static Player playerB;
    public static Fleet fleetA;

    public static Ocean pla;
    public static Ocean plb;

    public static BattleShipClientInterface battleShipClientInterface;


    @Override
    public void stopFunction(BattleShipClientInterface battleShipClientInterface, String string) throws RemoteException {
        lblErrorMessage.setText(string);
        enableDisableButtons(false);
//        try {
//            LocateRegistry.getRegistry().unbind("BattleShipServerInterface");
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        }
        return;
        //System.exit(0);
    }

    @Override
    public void stopGame() throws RemoteException {
        System.exit(0);
    }

    @Override
    public void rmiGame(BattleShipClientInterface hi) throws RemoteException {

        lblErrorMessage.setText("Please enter the Name of the player");
        btnAssignName.setEnabled(true);
        //btnAssignRowandCol.setEnabled(true);
        battleShipClientInterface = hi;

        aOcean = new Ocean(minrow, mincol, maxrow, maxcol);
        playerA = new Player(aOcean, "player A", 'H', 'm');
    }

    @Override
    public void playTheGame(BattleShipClientInterface hi, Player a, Player b, Ocean oceana, Ocean oceanb) throws RemoteException {

        btnHitOrMiss.setEnabled(true);

        if (a != null) {
            playerA = a;
        }
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

        battleShipClientInterface = hi;

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

    private static void createAndShowGUI() {

        //region Setting up the look and feel for the region
        String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
        }
        //endregion

        JFrame frame = new JFrame("BattleShipGamePlayer1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Component contents = createComponents();
        frame.getContentPane().add(contents);

        //Display the window.

        InputMap im = btnAssignName.getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");

        InputMap im2 = btnAssignRowandCol.getInputMap();
        im2.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im2.put(KeyStroke.getKeyStroke("released ENTER"), "released");

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
        seventhPane.setLayout(new GridLayout(1, 5));

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
        seventhPane.add(btnAssignRowandCol);

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

    public static void enableDisableButtons(boolean flag) {
        if (!flag) {
            btnAssignName.setEnabled(false);
            btnPlaceShip.setEnabled(false);
            btnHitOrMiss.setEnabled(false);
            btnAssignRowandCol.setEnabled(false);
        } else {
            btnAssignName.setEnabled(true);
            btnPlaceShip.setEnabled(true);
            btnHitOrMiss.setEnabled(true);
            btnAssignRowandCol.setEnabled(true);
        }
    }

    public static void ActionListners() {

        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTheServer();
            }
        });

        btnPlaceShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xcord, ycord;
                if (fleetA.battleShip.orientation == null || fleetA.battleShip.orientation.isEmpty()) {
                    try {
                        xcord = txtXCord.getText();
                        fleetA.battleShip.xCoordinate = Integer.parseInt(xcord);

                        ycord = txtYCord.getText();
                        fleetA.battleShip.yCoordinate = Integer.parseInt(ycord);

                        fleetA.battleShip.orientation = txtPos.getText();
                        fleetA.battleShip.shipLength = 4;

                    } catch (Exception ex) {
                        lblErrorMessage.setText("Enter Integer value");
                    }
                    if (fleetA.battleShip.orientation != null && !fleetA.battleShip.orientation.isEmpty()) {
                        if (fleetA.battleShip.xCoordinate >= playerA.o.minrow && fleetA.battleShip.xCoordinate < playerA.o.maxrow && fleetA.battleShip.yCoordinate >= playerA.o.mincol && fleetA.battleShip.yCoordinate < playerA.o.maxcol) {
                            char mm = playerA.o.oc[fleetA.battleShip.xCoordinate][fleetA.battleShip.yCoordinate]; //This is saved to check whether the matrix has changed.
                            playerA.spo = CreateShip(playerA.o, fleetA.battleShip.xCoordinate, fleetA.battleShip.yCoordinate, fleetA.battleShip.orientation, fleetA.battleShip.battleShip, fleetA.battleShip.shipLength);// Create the ship with the parameters provided
                            if (playerA.spo.oc[fleetA.battleShip.xCoordinate][fleetA.battleShip.yCoordinate] == mm) { // Move forward only if the matrix is changed
                                fleetA.battleShip.orientation = null;
                            } else {
                                lblErrorMessage.setText("Battle Ship is placed");
                                for (int i = 0; i < maxrow; i++) {
                                    for (int j = 0; j < maxcol; j++) {
                                        panelOcean[i][j].setText(String.valueOf(playerA.o.oc[i][j]));
                                    }
                                }
                            }
                        } else {
                            fleetA.battleShip.orientation = null;
                            lblErrorMessage.setText("Invalid input");
                        }
                    }

                } else if (fleetA.carrierShip.orientation == null || fleetA.carrierShip.orientation.isEmpty()) {
                    try {
                        xcord = txtXCord.getText();
                        fleetA.carrierShip.xCoordinate = Integer.parseInt(xcord);

                        ycord = txtYCord.getText();
                        fleetA.carrierShip.yCoordinate = Integer.parseInt(ycord);

                        fleetA.carrierShip.orientation = txtPos.getText();
                        fleetA.carrierShip.shipLength = 3;

                    } catch (Exception ex) {
                        lblErrorMessage.setText("Enter Integer value");
                    }
                    if (fleetA.carrierShip.orientation != null && !fleetA.carrierShip.orientation.isEmpty()) {
                        if (fleetA.carrierShip.xCoordinate >= playerA.o.minrow && fleetA.carrierShip.xCoordinate < playerA.o.maxrow && fleetA.carrierShip.yCoordinate >= playerA.o.mincol && fleetA.carrierShip.yCoordinate < playerA.o.maxcol) {
                            char mm = playerA.o.oc[fleetA.carrierShip.xCoordinate][fleetA.carrierShip.yCoordinate]; //This is saved to check whether the matrix has changed.
                            playerA.spo = CreateShip(playerA.o, fleetA.carrierShip.xCoordinate, fleetA.carrierShip.yCoordinate, fleetA.carrierShip.orientation, fleetA.carrierShip.carrierShip, fleetA.carrierShip.shipLength);// Create the ship with the parameters provided
                            if (playerA.spo.oc[fleetA.carrierShip.xCoordinate][fleetA.carrierShip.yCoordinate] == mm) { // Move forward only if the matrix is changed
                                fleetA.carrierShip.orientation = null;
                            } else {
                                lblErrorMessage.setText("Carrier Ship is placed");
                                for (int i = 0; i < maxrow; i++) {
                                    for (int j = 0; j < maxcol; j++) {
                                        panelOcean[i][j].setText(String.valueOf(playerA.o.oc[i][j]));
                                    }
                                }
                            }
                        } else {
                            fleetA.carrierShip.orientation = null;
                            lblErrorMessage.setText("Invalid input");
                        }
                    }
                } else if (fleetA.destroyerShip.orientation == null || fleetA.destroyerShip.orientation.isEmpty()) {
                    try {
                        xcord = txtXCord.getText();
                        fleetA.destroyerShip.xCoordinate = Integer.parseInt(xcord);

                        ycord = txtYCord.getText();
                        fleetA.destroyerShip.yCoordinate = Integer.parseInt(ycord);

                        fleetA.destroyerShip.orientation = txtPos.getText();
                        fleetA.destroyerShip.shipLength = 2;

                    } catch (Exception ex) {
                        lblErrorMessage.setText("Enter Integer value");
                    }
                    if (fleetA.destroyerShip.orientation != null && !fleetA.destroyerShip.orientation.isEmpty()) {
                        if (fleetA.destroyerShip.xCoordinate >= playerA.o.minrow && fleetA.destroyerShip.xCoordinate < playerA.o.maxrow && fleetA.destroyerShip.yCoordinate >= playerA.o.mincol && fleetA.destroyerShip.yCoordinate < playerA.o.maxcol) {
                            char mm = playerA.o.oc[fleetA.destroyerShip.xCoordinate][fleetA.destroyerShip.yCoordinate]; //This is saved to check whether the matrix has changed.
                            playerA.spo = CreateShip(playerA.o, fleetA.destroyerShip.xCoordinate, fleetA.destroyerShip.yCoordinate, fleetA.destroyerShip.orientation, fleetA.destroyerShip.destroyerShip, fleetA.destroyerShip.shipLength);// Create the ship with the parameters provided
                            if (playerA.spo.oc[fleetA.destroyerShip.xCoordinate][fleetA.destroyerShip.yCoordinate] == mm) { // Move forward only if the matrix is changed
                                fleetA.destroyerShip.orientation = null;
                            } else {
                                lblErrorMessage.setText("Destroyer Ship is placed");
                                for (int i = 0; i < maxrow; i++) {
                                    for (int j = 0; j < maxcol; j++) {
                                        panelOcean[i][j].setText(String.valueOf(playerA.o.oc[i][j]));
                                    }
                                }
                            }
                        } else {
                            fleetA.destroyerShip.orientation = null;
                            lblErrorMessage.setText("Invalid input");
                        }
                    }
                } else if (fleetA.aircraftShip.orientation == null || fleetA.aircraftShip.orientation.isEmpty()) {
                    try {
                        xcord = txtXCord.getText();
                        fleetA.aircraftShip.xCoordinate = Integer.parseInt(xcord);

                        ycord = txtYCord.getText();
                        fleetA.aircraftShip.yCoordinate = Integer.parseInt(ycord);

                        fleetA.aircraftShip.orientation = txtPos.getText();
                        fleetA.aircraftShip.shipLength = 2;

                    } catch (Exception ex) {
                        lblErrorMessage.setText("Enter Integer value");
                    }
                    if (fleetA.aircraftShip.orientation != null && !fleetA.aircraftShip.orientation.isEmpty()) {
                        if (fleetA.aircraftShip.xCoordinate >= playerA.o.minrow && fleetA.aircraftShip.xCoordinate < playerA.o.maxrow && fleetA.aircraftShip.yCoordinate >= playerA.o.mincol && fleetA.aircraftShip.yCoordinate < playerA.o.maxcol) {
                            char mm = playerA.o.oc[fleetA.aircraftShip.xCoordinate][fleetA.aircraftShip.yCoordinate]; //This is saved to check whether the matrix has changed.
                            playerA.spo = CreateShip(playerA.o, fleetA.aircraftShip.xCoordinate, fleetA.aircraftShip.yCoordinate, fleetA.aircraftShip.orientation, fleetA.aircraftShip.aircraftShip, fleetA.aircraftShip.shipLength);// Create the ship with the parameters provided
                            if (playerA.spo.oc[fleetA.aircraftShip.xCoordinate][fleetA.aircraftShip.yCoordinate] == mm) { // Move forward only if the matrix is changed
                                fleetA.aircraftShip.orientation = null;
                            } else {
                                lblErrorMessage.setText("Aircraft Ship is placed. Handed over to next player");
                                txtXCord.setEnabled(false);
                                txtYCord.setEnabled(false);
                                txtPos.setEnabled(false);
                                btnPlaceShip.setEnabled(false);
                                try {
                                    for (int i = 0; i < maxrow; i++) {
                                        for (int j = 0; j < maxcol; j++) {
                                            panelOcean[i][j].setText(String.valueOf(playerA.o.oc[i][j]));
                                        }
                                    }
                                    battleShipClientInterface.rmiGame(maxrow, maxcol);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }

                            }
                        } else {
                            fleetA.aircraftShip.orientation = null;
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
                    playerA.player = txtPlayerName.getText();
                    lblPlayerName.setText(txtPlayerName.getText());
                    btnAssignRowandCol.setEnabled(true);
                    btnAssignName.setEnabled(false);
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
                int countera = 0;

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

                if (x < playerB.o.maxrow && x < playerB.o.maxcol && x >= playerB.o.minrow && x >= playerB.o.mincol) {
                    if (playerB.o.oc[x][y] == '~') {
                        playerB.o.oc[x][y] = playerB.Miss;
                        pla.oc[x][y] = playerB.Miss;
                        //Below for loop used to save the miss

                        for (int i = 0; i < maxrow; i++) {
                            for (int j = 0; j < maxcol; j++) {
                                panelOcean2[i][j].setText(String.valueOf(pla.oc[i][j]));
                            }
                        }
                        lblErrorMessage.setText("That was a miss. Handed over to next player");
                        try {
                            btnHitOrMiss.setEnabled(false);
                            battleShipClientInterface.playTheGame(playerA, playerB, pla, plb);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    } else if (playerB.o.oc[x][y] == playerB.Miss || playerB.o.oc[x][y] == playerB.Hit) {
                        lblErrorMessage.setText("This coordinates were supplied earlier.Handed over to next player");
                        try {
                            btnHitOrMiss.setEnabled(false);
                            battleShipClientInterface.playTheGame(playerA, playerB, pla, plb);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        //Below for loop used to save the Hit
                        playerB.o.oc[x][y] = playerB.Hit;
                        pla.oc[x][y] = playerB.Hit;
                        lblErrorMessage.setText("That was a Hit.");

                        for (int i = 0; i < maxrow; i++) {
                            for (int j = 0; j < maxcol; j++) {
                                panelOcean2[i][j].setText(String.valueOf(pla.oc[i][j]));
                            }
                        }
                    }
                    //This loop is used to increment the counter. The total number of coordinates used by ships are 11(4+3+2+2)
                    countera = 0;
                    for (int l = 0; l < playerB.o.maxrow; l++) {
                        for (int m = 0; m < playerB.o.maxcol; m++) {
                            if (playerB.o.oc[l][m] == playerB.Hit) {
                                countera++;
                            }
                        }
                    }
                    //checks if all the ships are down.
                    if (countera == 11) {
                        lblErrorMessage.setText("You Won the game");
                        try {
                            enableDisableButtons(false);
                            battleShipClientInterface.stopFunction(playerA.player + " Wins. You Lose");
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

        btnAssignRowandCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String mrow, mcol;
                mrow = txtMaxRow.getText();
                mcol = txtMaxCol.getText();

                if (mrow.matches("\\d+") && mcol.matches("\\d+")) {
                    if (Integer.parseInt(mrow) >= 4 && Integer.parseInt(mcol) >= 4 && Integer.parseInt(mrow) <= 15 && Integer.parseInt(mcol) <= 15) {
                        maxrow = Integer.parseInt(mrow);
                        maxcol = Integer.parseInt(mcol);
                        aOcean = new Ocean(minrow, mincol, maxrow, maxcol);
                        playerA = new Player(aOcean, playerA.player, playerA.Hit, playerA.Miss);
                        fleetA = new Fleet();

                        //btnAssignName.setEnabled(true);
                        btnPlaceShip.setEnabled(true);

                        btnAssignRowandCol.setEnabled(false);
                        lblErrorMessage.setText("Coordinates provided");

                        txtMaxRow.setEnabled(false);
                        txtMaxCol.setEnabled(false);

                    }else if(Integer.parseInt(mrow) > 15 && Integer.parseInt(mcol) > 15 ){
                        lblErrorMessage.setText("Please enter values less than or equal to 15");
                    }
                    else {
                        lblErrorMessage.setText("Please enter values greater than 3");
                    }
                } else {
                    lblErrorMessage.setText("Please enter Integer values for rows and column");
                }
            }
        });

        btnStopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    battleShipClientInterface.stopGame();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                System.exit(0);

            }
        });

    }

    public static void startTheServer() {
        try {
            BattleShip battleServer = new BattleShip();
            BattleShipServerInterface battleStub = (BattleShipServerInterface) UnicastRemoteObject.exportObject(battleServer, 0);

            Registry registry = LocateRegistry.createRegistry(8172);
            registry.bind("BattleShipServerInterface", battleStub);
        } catch (Exception e) {
            e.printStackTrace();
        }
        btnStartServer.setEnabled(false);
    }

    public static void main(String[] args) {
        //To send data to Old_Client, we need to register the interface in registry
        createAndShowGUI();
        enableDisableButtons(false);
        ActionListners();

//        enableDisableButtons(false);


    }


}
package JavaSem1.BattleShipRuzan;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * ServerConnection.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 * Id: $ ServerConnection.java v1.0, 2016/11/21$
 * Revision: First Revision
 */
public class ServerConnection extends Thread implements ActionListener
{
    FleetScreen f;
    Controller c;
    JButton res;
    JProgressBar jp;
    OceanScreen oc;
    JButton sb;
    TurnAndVictory tv;

    /**
     * Constructor that initializes the objects
     * @param f FleetScreen object
     * @param c Controller object
     * @param sb Jbutton object
     * @param res Jbutton object
     * @param jp JProgress bar object
     * @param oc OceanScreen object
     * @param tv Turn and Victory object
     */
    public ServerConnection(FleetScreen f, Controller c, JButton sb, JButton res,JProgressBar jp, OceanScreen oc, TurnAndVictory tv)
    {
        this.c = c;
        this.res = res;
        this.jp = jp;
        this.oc = oc;
        this.sb = sb;
        this.f = f;
        this.tv = tv;
    }

    /**
     * Method called by start to check if the connection is established
     */
    public void run()
    {
        c.fillIt(f.s);
        if (!c.connect(jp))
        {
            System.err.println("Could not connect.");
            System.exit(1);
        }
        else
        {
            res.setEnabled(true);
            try
            {
                c.doneWithPlaying();
            }
            catch(RemoteException e)
            {
                e.printStackTrace();
            }
        }
        sb.setText("Connected.");
        //sb.setEnabled(true);
    }

    /**
     * When connect is clicked it starts a thread for network connectivity
     * @param a action event
     */
    public void actionPerformed(ActionEvent a)
    {
        tv.start();
        f.wake(false);
        sb.setEnabled(false);
        sb.setText("Connecting...");
        start();
    }
}

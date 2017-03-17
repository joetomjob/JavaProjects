package JavaSem1.BattleShipRuzan;
import javax.swing.*;
import java.rmi.RemoteException;

/**
 * TurnAndVictory.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 * Id: $ TurnAndVictory.java v1.0, 2016/11/21$
 * Revision: First Revision
 */
public class TurnAndVictory extends Thread
{
    Controller c;
    OceanScreen os;
    static boolean myTurn;
    static char vic;

    /**
     * Constructor to initialize the variables
     * @param c
     * @param os
     */
    public TurnAndVictory(Controller c, OceanScreen os)
    {
        this.c = c;
        this.os = os;
        myTurn = false;
        vic = 'N';
    }

    /**
     * Method to choose the player's turn and also display who is the winner
     */
    public void run()
    {
        while(true)
        {
            os.wake(myTurn);
            if(vic == 'W')
            {
                try
                {
                    c.loss();
                }
                catch(RemoteException re)
                {
                    re.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "CONGRATULATONS!!! YOU HAVE WON!!!");
                System.exit(0);
            }
            else if(vic == 'L')
            {
                JOptionPane.showMessageDialog(null, "Sorry! You lose...");
                System.exit(0);
            }
            else if(vic == 'F')
            {
                try
                {
                    c.forceVic();
                }
                catch(RemoteException re)
                {
                    re.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Looks like you gave up :(");
                System.exit(0);
            }
            else if (vic == 'S')
            {
                JOptionPane.showMessageDialog(null, "Looks like your opponent gave up...CONGRATULATONS!!! YOU HAVE WON!!!");
                System.exit(0);
            }
        }
    }
}

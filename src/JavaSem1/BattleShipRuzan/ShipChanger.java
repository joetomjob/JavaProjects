package JavaSem1.BattleShipRuzan;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ShipChanger.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 * Id: $ ShipChanger.java v1.0, 2016/11/21$
 * Revision: First Revision
 */
public class ShipChanger implements ActionListener
{
    int len;
    FleetScreen gs;
    Controller c;
    static int done;
    JButton sb;

    /**
     * Constructor to initialize the ship and its attributes to place them
     * @param len
     * @param gs
     * @param c
     * @param sb
     */
    public ShipChanger(int len, FleetScreen gs, Controller c, JButton sb)
    {
        this.len = len;
        this.gs = gs;
        this.c = c;
        done = 0;
        this.sb = sb;
    }

    /**
     * Method to allow the user place a specified choosen ship
     * @param ae
     */
    public void actionPerformed(ActionEvent ae)
    {
        if(gs.s != null)
        {
            gs.setLen(len);
            Game.jr[gs.s.getLen() - 2].setEnabled(false);
            c.fillIt(gs.s);
            gs.s = null;
            done++;
        }
    }
}

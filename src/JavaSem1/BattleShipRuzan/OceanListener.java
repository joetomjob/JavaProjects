package JavaSem1.BattleShipRuzan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

/**
 * OceanListener.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 *
 * This is the interface
 *
 * Id: $ OceanListener.java v1.0, 2016/11/21$
 * Revision: First Revision
 */
public class OceanListener extends MouseAdapter
{
    OceanScreen gs;
    int lastx;
    int lasty;
    Controller c;
    boolean awake;
    JLabel turn;

    /**
     * The parametrized constructor
     * @param gs an instance of OceanScreen
     * @param c An instance of Controller
     * @param turn An instance of JLabel
     */
    public OceanListener(OceanScreen gs, Controller c, JLabel turn)
    {
        this.gs = gs;
        lastx = -1;
        lasty = -1;
        this.c = c;
        awake = false;
        this.turn = turn;
    }

    /**
     * Switches awake to true or false
     * @param aw The parameter
     */
    public void setAwake(boolean aw)
    {
        awake = aw;
    }

    /**
     * Records hits or misses
     * @param me An instance of MouseEvent
     */
    public void mouseClicked(MouseEvent me)
    {
        if(!awake)
        {
            turn.setText("Opponent's turn.");
            return;
        }
        turn.setText("Your turn.");
        int x = me.getX();// The x coordinate of clicking point
        int y = me.getY(); // The y coordinate of clicking point
        int width = gs.getWidth(); // Width of the screen
        int height = gs.getHeight(); //Height of the Screen
        int cellWidth = width / Game.MAX_COLUMN; // Width of the cell
        int cellHeight = height / Game.MAX_ROW; // Height og the cell

        if (x >= gs.xOffset && y >= gs.yOffset)
        {
            int column = (x - gs.xOffset) / cellWidth;
            int row = (y - gs.yOffset) / cellHeight;
            if (column == Game.MAX_COLUMN && row == Game.MAX_ROW)
            {
                return;
            }
            if (column >= 0 && row >= 0 && column < Game.MAX_COLUMN && row < Game.MAX_ROW)
            {
                try
                {
                    char outcome = c.fhit(row + 1, column + 1);
                    if(outcome != 'N')
                    {
                        c.ohit(row + 1, column + 1, outcome);
                        if (outcome == 'H')
                        {
                            String name = c.shit(row + 1, column + 1);
                            /*System.out.println(name);
                            if(name.equals("Nothing"))
                            {
                                for(int i = 1; i < jl.length; i++)
                                {
                                    if(jl[i].getText().equals(name))
                                    {
                                        jl[i].setEnabled(true);
                                    }
                                }
                            }*/
                            if(c.vic())
                            {
                                TurnAndVictory.vic = 'W';
                            }
                        } else if (outcome == 'M')
                        {
                            c.doneWithPlaying();
                        }
                    }
                }
                catch(RemoteException re)
                {
                    re.printStackTrace();
                }
            }

        }
        gs.repaint();
    }
}

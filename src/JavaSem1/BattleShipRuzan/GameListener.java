package JavaSem1.BattleShipRuzan;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Thread.sleep;

/**
 * GameListener.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 *
 * This is the interface
 *
 * Id: $ GameListener.java v1.0, 2016/11/21$
 * Revision: First Revision
 */
public class GameListener extends MouseAdapter
{
    FleetScreen gs;
    int lastx;
    int lasty;
    boolean awake;
    JButton sb;

    /**
     * A parametrized constructor
     * @param gs An instance of FleetScreen
     * @param sb An instance of JButton
     */
    public GameListener(FleetScreen gs, JButton sb)
    {
        this.gs = gs;
        lastx = -1;
        lasty = -1;
        awake = true;
        this.sb = sb;
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
     * Places the ships horizontally or vertically by switching them through clicking
     * @param me An instance of MouseEvent
     */
    public void mouseClicked(MouseEvent me)
    {
        if(!awake)
        {
            return;
        }
        //Point p = me.getPoint();
        int x = me.getX(); // The x coordinate of the clicking point
        int y = me.getY(); // The y coordinate of the clicking point
        if(lastx == x && lasty == y)
        {
            if(gs.orient == 'H')
            {
                gs.orient = 'V';
            }
            else
            {
                gs.orient = 'H';
            }
        }
        else
        {
            lastx = x;
            lasty = y;
        }
        int width = gs.getWidth(); // Th width of the screen
        int height = gs.getHeight(); // Height f the screen
        int cellWidth = width / gs.columnCount; //width of each cell
        int cellHeight = height / gs.rowCount; //height of each cell 

        if (x >= gs.xOffset && y >= gs.yOffset)
        {
            int column = (x - gs.xOffset) / cellWidth;
            int row = (y - gs.yOffset) / cellHeight;
            if (column == gs.columnCount && row == gs.rowCount)
            {
                return;
            }
            if (column >= 0 && row >= 0 && column < gs.columnCount && row < gs.rowCount)
            {
                //if((gs.orient == 'H' && column != 10) || (gs.orient == 'V' && row != 10))
                //{
                gs.selectCell(column, row);
                //}
            }
            if(ShipChanger.done == 3)
            {
                sb.setEnabled(true);
            }

        }
        gs.repaint();
    }
}

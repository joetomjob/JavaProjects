package JavaSem1.BattleShipRuzan;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FleetScreen.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 *
 * This is the interface
 *
 * Id: $ FleetScreen.java v1.0, 2016/11/21$
 * Revision: First Revision
 */
public class FleetScreen extends JPanel
{
    Ship s;
    List<Rectangle> cells;
    int columnCount = 10;
    int rowCount = 10;
    Point selectedCell;
    int xOffset;
    int yOffset;
    char orient;
    int len;
    boolean moved;
    int lastindex;
    char lastorien;
    int lastlen;
    Controller c;
    GameListener gl;

    /**
     * The next method is just a constructor
     * @param c An instance of controller
     * @param sb An instance of JButton
     * @throws IOException
     */
    public FleetScreen(Controller c, JButton sb) throws IOException
    {
        gl = new GameListener(this, sb);
        addMouseListener(gl);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder
                (raisedBevel, loweredBevel);
        setBorder(compound);
        xOffset = 0;
        yOffset = 0;
        selectedCell = null;
        orient = 'V';
        len = 2;
        moved = false;
        this.c = c;
        //first = true;
    }

    /**
     * The next method wakes or sleeps the GameListener
     * @param t A boolean value
     */
    public void wake(boolean t)
    {
        gl.setAwake(t);
    }

    /**
     * The next method takes a cell of given coordinates
     * @param r The row numebr
     * @param c The column number
     */
    public void selectCell(int r, int c)
    {
        if(r == -1 || c == -1)
        {
            selectedCell = null;
        }
        else
        {
            selectedCell = new Point(r, c);
        }
    }

    /**
     * Sets the len to the given parameter
     * @param l An interegr
     */
    public void setLen(int l)
    {
        len = l;
    }
    @Override
    /**
     * Overriding a paintComponent method
     */
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int height = getHeight();
        int width = getWidth();
        int cellWidth = width / columnCount;
        int cellHeight = height / rowCount;
        cells = new ArrayList<>(columnCount * rowCount);;

        int xOffset = (width - (columnCount * cellWidth)) / 2;
        int yOffset = (height - (rowCount * cellHeight)) / 2;
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                Rectangle cell = new Rectangle(
                        xOffset + (col * cellWidth),
                        yOffset + (row * cellHeight),
                        cellWidth,
                        cellHeight);
                cells.add(cell);
            }
        }
        g2d.setColor(Color.decode("#C2DFFF"));
        for(Rectangle cell : cells)
        {
            g2d.fill(cell);
        }
        g2d.setColor(Color.DARK_GRAY);
        for(int j = 0 ; j < c.s.length; j++)
        {
            if(c.s[j] == null)
            {
                continue;
            }
            int index = c.s[j].getyCoord() - 1  + ((c.s[j].getxCoord() - 1 )* columnCount);
            if(c.s[j].getOrien() == 'V')
            {
                for(int i = 0; i < c.s[j].getLen(); i++)
                {
                    Rectangle cell = cells.get(index);
                    index += columnCount;
                    g2d.fill(cell);
                }
            }
            else
            {
                for(int i = 0; i < c.s[j].getLen(); i++)
                {
                    Rectangle cell = cells.get(index);
                    index++;
                    g2d.fill(cell);
                }
            }

        }
        if(selectedCell != null)
        {
            int index = selectedCell.x + (selectedCell.y * columnCount);
            if (index == lastindex)
            {
                if (orient == 'H')
                {
                    orient = 'V';
                } else
                {
                    orient = 'H';
                }
            }
            if (orient == 'H' && index % columnCount >= columnCount - (len - 1))
            {
                orient = 'V';
            } else if (orient == 'V' && !(index / columnCount <= rowCount - 1 - (len - 1)))
            {
                orient = 'H';
            }
            boolean pos = c.fillFunc(selectedCell.y + 1, selectedCell.x + 1, len, orient);
            if (index == rowCount * columnCount - 1)
            {
                index = lastindex;
                orient = lastorien;
            }
            System.out.println(index + " " +pos);
            if (!pos)
            {
                index = lastindex;
                orient = lastorien;
                //len = lastlen;
            }
            else
            {
                s = new Ship(selectedCell.y + 1, selectedCell.x + 1, len, orient, Game.SHIPS[len - 2]);
            }
            /*if(index == rowCount * columnCount - 1)
            {
                index = lastindex;
                System.out.println(index);
            }

            if(index % columnCount >= columnCount - (len - 1) && !(index/columnCount <= rowCount - 1 - (len - 1)))
            {
                index = lastindex;
            }*/
            lastindex = index;
            lastorien = orient;
            lastlen = len;

            if (orient == 'V')
            {
                for (int i = 0; i < len; i++)
                {
                    Rectangle cell = cells.get(index);
                    index += columnCount;
                    g2d.fill(cell);
                }
            } else
            {
                for (int i = 0; i < len; i++)
                {
                    Rectangle cell = cells.get(index);
                    index++;
                    g2d.fill(cell);
                }
            }
        }
        g2d.setColor(Color.DARK_GRAY);
        for(Rectangle cell : cells)
        {
            g2d.draw(cell);
        }
    }
}

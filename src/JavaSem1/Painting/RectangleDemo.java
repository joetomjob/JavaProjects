package Painting;

/*
 * Swing version.
 */

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Displays a framed area.  When the user clicks within
 * the area, this program displays a filled rectangle
 * and a string indicating the coordinates where the
 * click occurred.
 */

public class RectangleDemo {
    JLabel label;

    void buildUI(Container container) {
        container.setLayout(new BoxLayout(container,
                BoxLayout.Y_AXIS));

        RectangleArea rectangleArea = new RectangleArea(this);
        container.add(rectangleArea);

        label = new JLabel("Click within the framed area.");
        container.add(label);
    }

    public void updateLabel(Point point) {
        label.setText("Click occurred at coordinate ("
                + point.x + ", " + point.y + ").");
    }

    //Called only when this is run as an application.
    public static void main(String[] args) {
        JFrame f = new JFrame("RectangleDemo");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        RectangleDemo controller = new RectangleDemo();
        controller.buildUI(f.getContentPane());
        f.pack();
        f.setVisible(true);
    }
}

class RectangleArea extends JPanel {
    Point point = null;
    RectangleDemo controller;
    Dimension preferredSize = new Dimension(300,100);
    int rectWidth = 50;
    int rectHeight = 50;

    public RectangleArea(RectangleDemo controller) {
        this.controller = controller;

        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder
                (raisedBevel, loweredBevel);
        setBorder(compound);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                point = e.getPoint();
                repaint();
            }
        });
    }

    public Dimension getPreferredSize() {
        return preferredSize;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  //paint background

        if (point != null) {
            g.drawRect(point.x, point.y,
                    rectWidth - 1, rectHeight - 1);
            g.setColor(Color.yellow);
            g.fillRect(point.x + 1, point.y + 1,
                    rectWidth - 2, rectHeight - 2);

            controller.updateLabel(point);
        }
    }
}

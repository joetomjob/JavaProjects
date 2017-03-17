package Networking;

/**
 * This class implements a point in a two dimensional
 * area.
 * All methods print the method name, when they are called.
 * state information includes:
 *
 * @version   $Id$
 *
 * RIT's home page: <a href="http://www.cs.rit.edu/~hpb">RIT</a>
 *
 * Revisions:
 *	$Log$
 */
import java.io.*;


public class Point implements Serializable {

    private int x;		// x coordinate of the point
    private int y;		// y cooridnate of the point

    /**
     * Constructor.
     * initialize x and y values of a point
     *
     * @param       x	x coordinate
     * @param       y	y coordinate
     *
     * @return	a Point object
     */
    public Point(int _x, int _y){
        this.x = _x;
        this.y = _y;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
    }

    private void readObject(ObjectInputStream s) throws IOException  {
        try {
            s.defaultReadObject();
        }
        catch ( ClassNotFoundException e)	{
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * initialzes x and y of a point.
     *
     * @param       x	int x coordinate
     * @param       y	int y coordinate
     *
     * @return	a Point object
     */
    public Point initPoint(int _x, int _y){

        this.x = _x;
        this.y = _y;

        return this;
    }

    /**
     * moves a point
     *
     * @param       _x	int delta x value
     * @param       _y	int delta y value
     *
     * @return	a Point object
     */
    public Point move(int _x, int _y){

        this.x += _x;
        this.y += _y;
        return this;
    }

    /**
     * Returns the x coordinate of a point
     *
     * @return x value
     */
    public int getX(){
        return this.x;
    }

    /**
     * Returns the y coordinate of a point
     *
     * @return y value
     */
    public int getY(){
        return this.y;
    }

    /**
     * Returns a String reperesentation of the point
     *
     * @return String reprasentation of the point
     */
    public String toString(){
        return "Point at (" + x + "/" + y + ")";
    }
}
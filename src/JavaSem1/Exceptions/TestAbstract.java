package Exceptions;


abstract class Area {

    public abstract int area() throws Exception;
    public abstract int perimeter() throws Exception;

}

class Circle extends Area {

    private int radius;

    public Circle(int _radius) throws Exception {
        if ( radius < 0 )
            throw new Exception("Negativ radius (" +
                    radius + ") is not acceptable");
        else
            radius = _radius;
    }

    public int area() throws Exception	{
        if ( radius < 0 )
            throw new Exception("Circle is not initialized");
        else
            return (int)(Math.PI * radius * radius);
    }

    public int perimeter() throws Exception {
        if ( radius < 0 )
            throw new Exception("Circle is not initialized");
        else
            return (int)(Math.PI * radius * radius);
    }

}

class Square extends Area {

    private int length;

    public Square(int _length) throws Exception {
        if ( _length < 0 )
            throw new Exception("Negative length (" +
                    length + ") is not acceptable");
        else
            length = _length;
    }

    public int area() throws Exception {
        if ( length < 0 )
            throw new Exception("Square is not initialized");
        else
            return length * length;
    }

    public int perimeter() throws Exception {
        if ( length < 0 )
            throw new Exception("Square is not initialized");
        else
            return 4 * length;
    }

}

public class TestAbstract {

    public static void main(String args[])
    {
        Square aSquare;
        Circle aCircle;

        for (int index = 1; index >=  -1; index -= 2 ) {
            try {
                aSquare = new Square(index);
                aCircle = new Circle(index);

                System.out.println( "Circle");
                System.out.println( "\t" +  aCircle.area() );
                System.out.println( "\t" +  aCircle.perimeter() );

                System.out.println( "Square");
                System.out.println( "\t" +  aSquare.area() );
                System.out.println( "\t" +  aSquare.perimeter() );
            }
            catch ( Exception e )	{
                System.out.println(e.getMessage() );
            }
        }

    }
}

package Exceptions;

import java.io.*;
public class FileIO {

    static void cp(String inF, String outF )	{
        DataInputStream in;
        DataOutputStream out;

        try {
            in = new DataInputStream(
                    new FileInputStream(inF) );
            out = new DataOutputStream(
                    new FileOutputStream(outF) );
            try {
                do {
                    out.writeByte (in.readByte() );
                } while ( true );
            }
            catch ( EOFException e )	{
                in.close();
                out.close();
            }
        }
        catch ( FileNotFoundException e )	{
            e.printStackTrace();
            System.out.println("Can't find the file!");
        }
        catch ( IOException e )	{  // Throws: IOException !!!
            e.printStackTrace();
            System.out.println("Could not be opened for writing!");
        }
        catch ( Exception e )	{
            System.out.println("Can't find the file!");
        }
    }

    public static void main(String args[]) {
        String[] x = {"text.txt","text1.txt"};
        if ( x.length != 2 )
            System.out.println("Usage: java FileIO f1 f2");
        else	{
            System.out.println(x[0] + "  " + x[1] );
            cp(x[0], x[1]);
        }
    }
}
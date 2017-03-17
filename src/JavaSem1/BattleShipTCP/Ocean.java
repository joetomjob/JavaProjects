package BattleShipTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

//This class saves the ocean in a character array
public class Ocean implements Serializable {
    public int minrow, mincol, maxrow, maxcol;
    public char[][] oc;
    public int[] number;
    public DataInputStream dataInputStream;
    public DataOutputStream dataOutputStream;

    public Ocean() {
        this.number = new int[4];
    }
    //This is the constructor. The default costructor is overridden with the new one. Here the character array is filled wiht '~'
    public Ocean(int minrow, int mincol, int maxrow, int maxcol, DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException{
        if (minrow < 0 || mincol < 0) {

            dataOutputStream.writeUTF("Minimum value cannot be less than zero");
            dataOutputStream.writeBoolean(false);
            //System.out.println("Minimum value cannot be less than zero");
            System.exit(0);
        } else {
            oc = new char[maxrow][maxcol];
            this.minrow = minrow;
            this.mincol = mincol;
            this.maxrow = maxrow;
            this.maxcol = maxcol;
            this.dataInputStream = dataInputStream;
            this.dataOutputStream = dataOutputStream;

            //This for loop is used to feed '~' into the character array
            for (int i = 0; i < maxrow; i++) {
                for (int j = 0; j < maxrow; j++) {
                    oc[i][j] = '~';
                }
            }
        }

    }

    public void DisplaytheOcean(Ocean ocean, String player) throws IOException{
        System.out.println("The Ocean of "+ player +" is : ");
        for (int i = 0; i < maxrow; i++) {
            for (int j = 0; j < maxrow; j++) {
                System.out.print(ocean.oc[i][j]);
                System.out.print('\t');
            }
            System.out.print('\n');
        }
    }
}

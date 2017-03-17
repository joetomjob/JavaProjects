package HW8;

/**
 * Created by Admin on 16-10-2016.
 */
public class binarytest {
    public static void main(String[] args) {
        byte[] newb = new byte[1];
        int i = 4;
        newb[0] |= 2;
        newb[0] <<= 4;

        System.out.println(newb[0]);

    }

}

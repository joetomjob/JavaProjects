package HW8;
/**
 *
 * AcgtOutputStream.java
 *
 * Hw 8.2
 *
 * @author: Joe Tom Job
 * @author: Rao,V C S Praneeth
 *
 * Prof: Thomas Rossi
 *
 *
 *
 *
 */

import java.io.FileOutputStream;
import java.io.IOException;


public class AcgtOutputStream { // Declaring the acgt class for the fasta file

    FileOutputStream file;

    public AcgtOutputStream(FileOutputStream f) {
        this.file = f;
    }

    public void write(byte[] buffer, int start, int end) throws IOException {  // the write method is declared with exception
        int i = 0;
        while (i < end) {
            byte[] newb = new byte[1];
            for (int j = 0; j < 2; j++) {
                if (i < end) {
                    if (buffer[i] == 'a') {                                    // if the character is a
                        newb[0] |= 0x05;
                    } else if (buffer[i] == 'c') {                             // if the character is c
                        newb[0] |= 0x06;
                    } else if (buffer[i] == 'g') {                             // if the character is g
                        newb[0] |= 0x07;
                    } else if (buffer[i] == 't') {                             // if the character is t
                        newb[0] |= 0x04;
                    }else if (buffer[i] == ' ') {                              // if the character is space
                        newb[0] |= 0x1;
                    }else if (buffer[i] == '\n') {                             // if the character is newline
                        newb[0] |= 0x2;
                    }else{
                        newb[0] |= 0x1;                                        // if the character is anything else other than a c g t, space is entered
                    }
                    if (j == 0) {
                        newb[0] <<= 4;
                    }
                    i++;
                }
            }
            file.write(newb, 0, 1);                                            // the newb is written to file
        }
    }

    public void close()throws IOException{                                    // is file not found exception is thrown
        file.close();                                                         // the file is closed
    }


}

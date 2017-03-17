package HW8;
/**
 *
 * Acgtinputstream.java
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
import java.io.FileInputStream;
import java.io.IOException;

public class Acgtinputstream {                                       // declare the input stream to compress the file
    FileInputStream file;

    public Acgtinputstream(FileInputStream f){
        this.file = f;
    }

    public int read(byte[] buffer)throws IOException{               // the file is read and stored in buffer and exception is used when file not found
        for(int i=0;i<buffer.length;i++){                           // for the length of buffer and the next iteration
            buffer[i] = 0;
        }

        int l=0;
        int c =0;
        int k =0;

        while(c<buffer.length){
            byte[] newb = new byte[1];
            if((k = file.read(newb))> 0){
                l = l+2;
            }
            else{
                if(l==0){
                    return -1;
                }
                else{
                    break;
                }
            }
            int fb = newb[0] & 0x0F;         // and operation with 00001111 to get  the first 4 bytes
            int lb = newb[0]>>>4;            //shifting 4 bytes to right to get the last 4 bytes

            char r =' ';
            if(lb==5){                       //if the last 4 bytes  corresponds to 5, the character is a
                r='a';
            }
            else if(lb==6){                 //if the last 4 bytes  corresponds to 6, the character is c
                r='c';
            }
            else if(lb==7){                 //if the last 4 bytes  corresponds to 7, the character is g
                r='g';
            }
            else if(lb==4){                 //if the last 4 bytes  corresponds to 4, the character is t
                r='t';
            }
            else if(lb==1){                 //if the last 4 bytes  corresponds to 1, the character is space
                r=' ';
            }
            else if(lb==2){                 //if the last 4 bytes  corresponds to 2, the character is a new line
                r='\n';
            }

            buffer[c] |= r;                 //or operation to the buffer, setting the buffer[0] to the character
            r=' ';                          //reinitialize r

            if(fb==5){                      //if the last 4 bytes  corresponds to 5, the character is a
                r='a';
            }
            else if(fb==6){                 //if the last 4 bytes  corresponds to 6, the character is c
                r='c';
            }
            else if(fb==7){                 //if the last 4 bytes  corresponds to 7, the character is g
                r='g';
            }
            else if(fb==4){                 //if the last 4 bytes  corresponds to 4, the character is t
                r='t';
            }
            else if(fb==1){                 //if the last 4 bytes  corresponds to 1, the character is space
                r=' ';
            }
            else if(fb==2){                 //if the last 4 bytes  corresponds to 2, the character is new line
                r='\n';
            }
            buffer[++c] |= r;

            c++;
        }

        return l;
    }

    public void close() throws IOException{                                 // an exception is thrown if the file is not found
        file.close();                                                       // the file is closed
    }

}

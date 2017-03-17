package HW8;
/**
 *
 * AcgtOutputStreamtest.java
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;




public class Acgtoutputstreamtest {                                  // the creating a class to test the file
    public static byte[] buffer = new byte[1024];


    public static void main(String[] args) throws IOException{      // declaring the main function
        String file=args[0];
        //String file = "mrna_compress.Z";

        if(file.endsWith(".Z")){                                   // if the file ends with .z it decompress the file
            deCompressFile(file);
        }
        else{
            compressFile(file);                                   // if the file doesn't end with .z then it compresses the file
        }
    }
    public static void compressFile(String file) throws IOException {     // Compressing method is declared
        FileInputStream in_file = new FileInputStream(file);              // Normal input stream is declared to get the normal file
        int content;

        AcgtOutputStream acgt_outfile = new AcgtOutputStream(new FileOutputStream(file.split("\\.")[0]+"_compress.Z")); // the file is compressed and .z extension is attached
        while ((content = in_file.read(buffer)) > 0) {                                                                  // reading the normal file and adding it to the buffer
            acgt_outfile.write(buffer,0,content);
        }
        acgt_outfile.close();                                                                                           // the output file is closed
        in_file.close();                                                                                                // the input file is closed
    }

    public static void deCompressFile(String  file)throws IOException{                    // Decompressing method is declared
        Acgtinputstream acg_infile = new Acgtinputstream(new FileInputStream(file));       // Using GZIP the inputstream is eastablished from the file
        int content;
        FileOutputStream out_file = new FileOutputStream(file+"_uncompressed.Z.uc");       // The file is split from the .z and is uncompressed
        while ((content = acg_infile.read(buffer)) > 0) {                                  // The content is read in buffer and if it is greater 0
            out_file.write(buffer,0,content);
        }
        acg_infile.close();                                                                // the acgt file is closed
        out_file.close();                                                                  // the output file is closed
    }

}

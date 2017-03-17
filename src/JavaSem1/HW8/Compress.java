/**
 *
 * Compress.java
 *
 * Hw 8.1
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
import java.io.*;
import java.io.InputStream;
import java.util.zip.*;

public class Compress {
    public static byte[] buffer = new byte[1024];
    public static void main(String[] args) throws IOException {

        int file_content;

        String file=args[0];
        //String file = "test.txt";


        if(file.endsWith(".Z")){
            deCompressFile(file);
        }
        else{
            compressFile(file);
        }

    }
    public static void compressFile(String file) throws IOException{                                                    // Compressing method is declared
        FileInputStream in_file = new FileInputStream(new File(file));                                                  // Normal input stream is declared to get the normal file
        int content;
        GZIPOutputStream gzip_outfile = new GZIPOutputStream(new FileOutputStream(file.split("\\.")[0]+"_compress.Z")); // the file is compressed and .z extension is attached
        while ((content = in_file.read(buffer)) > 0) {                                                                      
            gzip_outfile.write(buffer,0,content);
        }
        in_file.close();
        gzip_outfile.finish();
        gzip_outfile.close();
    }
    public static void deCompressFile(String  file)throws IOException{                                                  // Decompressing method is declared here
        GZIPInputStream gzip_infile = new GZIPInputStream(new FileInputStream(file));                                   // Using GZIP the inputstream is eastablished from the file
        int content;
        FileOutputStream out_file = new FileOutputStream(file.split("\\.")[0]+"_uncompressed.Z.uc");                    // The file is split from the .z and is uncompressed
        while ((content = gzip_infile.read(buffer)) > 0) {                                                              // The content is read in buffer and if it is greater 0
            out_file.write(buffer,0,content);
        }
        gzip_infile.close();                                                                                            // the gzip file is closed
        out_file.close();                                                                                               // the out file is closed
    }
}

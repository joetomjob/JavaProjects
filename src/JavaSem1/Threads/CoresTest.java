package Threads;
import java.util.*;

public class CoresTest extends Thread    {
    static final int soManyThreads  = Runtime.getRuntime().availableProcessors();
    static final int soOftenPerThread = 1000000;
    static long milliSeconds = 0;
    double result = 0;
    int id;

    public CoresTest(int index)	{
        id = index;
    }
    public static void init()  {
        milliSeconds = System.currentTimeMillis();
        //System.out.println("milli is : "+milliSeconds);
    }
    public static void end(String s)   {
        System.err.println(s + ":       " + ( System.currentTimeMillis() - milliSeconds) );
        System.err.println(" # of cores" +   ":       " +
                Runtime.getRuntime().availableProcessors() );
    }
    public void singleThreadTest (int soOften) { //this task takes n time
        for (int index = 0; index < soOften; index ++ )		{
            for ( int k = 0; k < 1000; k ++ )
                for ( int j = 0; j < 1; j ++ )
                    result = Math.sqrt(index);
        }

    }
    public void run () {
        singleThreadTest(soOftenPerThread);
    }
    public static void main (String args []) {
        CoresTest single = new CoresTest(0);
        CoresTest[] many   = new CoresTest[soManyThreads];
        CoresTest o = null;
        init();
        single.singleThreadTest(soOftenPerThread * soManyThreads); //Here concept of threads is not used.
        end("Single Thread Test");//single thread takes n time to run the task
//------------------------------------------//
        init();
        for ( int index = 0; index < soManyThreads; index ++ )	{ // The abv task is divided across 4 threads,
            many[index] = new CoresTest(index); //so we expect it to finish by n/4 time
            many[index].start();
        }
        try {
            for ( int index = 0; index < soManyThreads; index ++ )	{
                many[index].join();
            }
        } catch (Exception e ) {
            e.printStackTrace();}
        end("Multiple Core Test");
    }
}
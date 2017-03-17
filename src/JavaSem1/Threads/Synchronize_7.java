package Threads;

import java.util.*;

public class Synchronize_7 extends Thread    {
    /*if a method is static and synchronized, it  will be synchronized for all abjects*/
    private String info;
    private Vector aVector;

    public Synchronize_7(String info, Vector aVector) {
        this.info    = info;
        this.aVector = aVector;
    }

    static synchronized void staticInProtected1(String s) {
        System.err.println(s + ": ---->");
        try {
            sleep(1000);
        }
        catch (  InterruptedException e ) {
            System.err.println("Interrupted!");
        }
        staticInProtected2(s);
        System.err.println(s + ": <----");
    }

    static synchronized void staticInProtected2(String s) {
        System.err.println(s + ": ====>");
        try {
            sleep(1000);
        }
        catch (  InterruptedException e ) {
            System.err.println("Interrupted!");
        }
        System.err.println(s + ": ====>");
    }

    public void run () {
        staticInProtected1(info);
    }

    public static void main (String args []) {
        Vector aVector = new Vector();
        Synchronize_7 aClassT_0 = new Synchronize_7("first",  aVector);
        Synchronize_7 aClassT_1 = new Synchronize_7("second", aVector);

        Synchronize_7.staticInProtected1("main");
        aClassT_0.start();
        aClassT_1.start();
        aClassT_0.staticInProtected1("aClassT_0");
        aClassT_1.staticInProtected1("aClassT_1");
            /*if a method is static and synchronized, it  will be synchronized for all abjects*/
    }
}
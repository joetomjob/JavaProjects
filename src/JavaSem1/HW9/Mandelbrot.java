package HW9;

// original from: http://rosettacode.org/wiki/Mandelbrot_set#Java
// modified for color

import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Mandelbrot extends JFrame {

    private final int MAX 	= 5000;
    private final int LENGTH   	= 800;
    private final double ZOOM  	= 1000;
    private BufferedImage theImage;
    private int[] colors = new int[MAX];
    static int NoOfThreads  = Runtime.getRuntime().availableProcessors();
    static long milliSeconds = 0;

    public Mandelbrot() {
        super("Mandelbrot Set");

        initColors();
        setBounds(100, 100, LENGTH, LENGTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        theImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    public void createSet()	{
        //theImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        double zx, zy, cX, cY;
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - LENGTH) / ZOOM;
                cY = (y - LENGTH) / ZOOM;
                int iter = 0;
                double tmp;
                while ( (zx * zx + zy * zy < 10 ) && ( iter < MAX - 1 ) ) {	// this is the part for the parallel part
                    tmp = zx * zx - zy * zy + cX;				// this is the part for the parallel part
                    zy = 2.0 * zx * zy + cY;					// this is the part for the parallel part
                    zx = tmp;							// this is the part for the parallel part
                    iter++;							// this is the part for the parallel part
                }								// this is the part for the parallel part
                if ( iter > 0 )							// this is the part for the parallel part
                    theImage.setRGB(x, y, colors[iter]);			// this is the part for the parallel part
                else								// this is the part for the parallel part
                    theImage.setRGB(x, y, iter | (iter << 8));		// this is the part for the parallel part
            }
            repaint();
        }
    }

    public void createSetMultiThreaded(int tind, int cores) {

        double zx, zy, cX, cY;

        int layers = getHeight() / (cores);

        int sw = tind*layers;
        int ew = sw+layers;
        if(tind == NoOfThreads-1){
            ew = getWidth();
        }

        for (int y = 0; y < getHeight(); y++) {
            for (int x = sw; x < ew; x++) {
                zx = zy = 0;
                cX = (x - LENGTH) / ZOOM;
                cY = (y - LENGTH) / ZOOM;
                int iter = 0;
                double tmp;
                while ((zx * zx + zy * zy < 10) && (iter < MAX - 1)) {    // this is the part for the parallel part
                    tmp = zx * zx - zy * zy + cX;                // this is the part for the parallel part
                    zy = 2.0 * zx * zy + cY;                    // this is the part for the parallel part
                    zx = tmp;                            // this is the part for the parallel part
                    iter++;                            // this is the part for the parallel part
                }                                // this is the part for the parallel part
                if (iter > 0)                            // this is the part for the parallel part
                    theImage.setRGB(x, y, colors[iter]);            // this is the part for the parallel part
                else                                // this is the part for the parallel part
                    theImage.setRGB(x, y, iter | (iter << 8));        // this is the part for the parallel part
            }

            repaint();
        }


    }

    public void initColors() {
        for (int index = 0; index < MAX; index++) {
            colors[index] = Color.HSBtoRGB(index/256f, 1, index/(index+8f));
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(theImage, 0, 0, this);
    }

    public static void init()  {
        milliSeconds = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        init();
        Mandelbrot aMandelbrot = new Mandelbrot();
        aMandelbrot.setVisible(true);
        aMandelbrot.createSet();
        System.out.println("The time for single threaded mandelbrot is : "+ (System.currentTimeMillis()-milliSeconds));

        init();
        final Mandelbrot aMandelThread = new Mandelbrot();
        aMandelThread.setVisible(true);

        Thread[] th = new Thread[NoOfThreads];
        for(int i = 0; i<NoOfThreads;i++)
        {
            final int x = i;
            th[i] = new Thread(){
                public void run(){
                    aMandelThread.createSetMultiThreaded(x,NoOfThreads);
                }
            };
            th[i].run();
        }
        System.out.println("The time for multi threaded mandelbrot is : "+ (System.currentTimeMillis()-milliSeconds));

    }
}


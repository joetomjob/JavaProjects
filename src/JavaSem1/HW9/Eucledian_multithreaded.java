//package HW9;

import java.util.Random;

class NewPoint1 {
    int x;
    int y;
    int z;
}

public class Eucledian_multithreaded extends Thread {
    static int NoOfThreads = Runtime.getRuntime().availableProcessors();
    static long milliSeconds = 0;

    static double minDistance;
    static NewPoint1 firstPoint = new NewPoint1();
    static NewPoint1 secondPoint = new NewPoint1();
    static NewPoint1[] pt;

    int z;
    NewPoint1[] newpt;
    int div;

    public static double[] mindistancethread = new double[NoOfThreads];
    public static NewPoint1[][] threadPoint = new NewPoint1[NoOfThreads][2];

    public Eucledian_multithreaded(int z, NewPoint1[] pt, int div) {
        this.z = z;
        this.newpt = pt;
        this.div = div;

    }

    public static void init() {
        milliSeconds = System.currentTimeMillis();
    }

    public void run() {
        int start = z * div;
        int end;

        if (z < NoOfThreads)
            end = start + div;
        else
            end = pt.length;

        minDistance = DistanceBetweenPoints(pt[0], pt[1]);
        firstPoint = pt[0];
        secondPoint = pt[1];

        for (int k = start; k < end; k++) {
            for (int j = k + 1; j < pt.length; j++) {
                if (!(pt[k].x == pt[j].x) && (pt[k].z == pt[j].z) && (pt[k].z == pt[j].z)) {
                    double r = DistanceBetweenPoints(pt[k], pt[j]);
                    if (r < minDistance) {
                        minDistance = r;
                        firstPoint = pt[k];
                        secondPoint = pt[j];
                    }
                }
            }
        }

        mindistancethread[z] = minDistance;
        threadPoint[z][0] = firstPoint;
        threadPoint[z][1] = secondPoint;

    }

    public static double DistanceBetweenPoints(NewPoint1 x, NewPoint1 y) {
        double l = Math.sqrt(Math.pow((y.z - x.z), 2) + Math.pow((y.y - x.y), 2) + Math.pow((y.x - x.x), 2));
        return l;
    }

    public static void GetRandomPoints(int points) {
        pt = new NewPoint1[points]; //Point[] x = new Point[points];
        Random position = new Random();
        NewPoint1 t;
        for (int i = 0; i < points; i++) {
            t = new NewPoint1();
            t.x = position.nextInt(1000);
            t.y = position.nextInt(1000);
            t.z = position.nextInt(1000);
            pt[i] = new NewPoint1();
            pt[i].x = t.x;
            pt[i].y = t.y;
            pt[i].z = t.z;
        }
    }

    public static void FindMinDistance_Single(int points) {

        minDistance = DistanceBetweenPoints(pt[0], pt[1]);
        firstPoint = pt[0];
        secondPoint = pt[1];

        for (int i = 0; i < points; i++) {
            for (int j = i + 1; j < points; j++) {
                if (!(pt[i].x == pt[j].x) && (pt[i].z == pt[j].z) && (pt[i].z == pt[j].z)) {
                    double r = DistanceBetweenPoints(pt[i], pt[j]);
                    if (r < minDistance) {
                        minDistance = r;
                        firstPoint = pt[i];
                        secondPoint = pt[j];
                    }
                }
            }
        }
        System.out.println(minDistance);
        System.out.println("Single Thread");
        System.out.println("(" + firstPoint.x + "/" + firstPoint.y + "/" + firstPoint.z + ")  (" + secondPoint.x + "/" + secondPoint.y + "/" + secondPoint.z + ")  : " + (System.currentTimeMillis() - milliSeconds));
    }

    private static void FindMinDistance_Multi(int noofpoints) {
        int div = noofpoints / NoOfThreads;
        int f = div;
        if (div < 2) {
            NoOfThreads = noofpoints / 2;
            div = noofpoints / NoOfThreads;
        }

        Eucledian_multithreaded[] thread = new Eucledian_multithreaded[NoOfThreads];

        for (int i = 0; i < NoOfThreads; i++) {
            thread[i] = new Eucledian_multithreaded(i, pt, div);
            thread[i].start();
        }
        for (int i = 0; i < NoOfThreads; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double min = mindistancethread[0];
        int threadIndex = 0;

        if (f < 2) {
            for (int i = 0; i < NoOfThreads; i++) {
                if (min > mindistancethread[i]) {
                    min = mindistancethread[i];
                    threadIndex = i;
                }
            }
        } else {
            for (int i = 0; i < mindistancethread.length; i++) {
                if (min > mindistancethread[i]) {
                    min = mindistancethread[i];
                    threadIndex = i;
                }
            }
        }

        System.out.println(mindistancethread[threadIndex]);
        System.out.println("Multi Thread");
        System.out.println("(" + threadPoint[threadIndex][0].x + "/" + threadPoint[threadIndex][0].y + "/" + threadPoint[threadIndex][0].z + ")  (" + threadPoint[threadIndex][1].x + "/" + threadPoint[threadIndex][1].y + "/" + threadPoint[threadIndex][1].z + ") : " + (System.currentTimeMillis() - milliSeconds));
    }

    public static void main(String[] args) {
        int noofpoints = Integer.parseInt(args[0]);

//        int noofpoints = 2;

        GetRandomPoints(noofpoints);
        init();
        FindMinDistance_Single(noofpoints);
        System.out.println();
        init();
        FindMinDistance_Multi(noofpoints);

    }
}



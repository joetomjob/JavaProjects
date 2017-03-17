//package HW9;
//
//import java.util.Random;
//
//
//class NewPoint{
//    int x;
//    int y;
//    int z;
//}
//
//public class Eucledian_Distance {
//    static final int NoOfThreads  = Runtime.getRuntime().availableProcessors();
//    static long milliSeconds = 0;
//
//    double minDistance;
//    NewPoint firstPoint = new NewPoint();
//    NewPoint secondPoint = new NewPoint();
//
//    public static void init()  {
//        milliSeconds = System.currentTimeMillis();
//    }
//
////    public void run(){
////
////    }
//    public double DistanceBetweenPoints(NewPoint x, NewPoint y){
//        double l = Math.sqrt(Math.pow((y.z - x.z),2)+Math.pow((y.y - x.y),2) + Math.pow((y.x - x.x),2));
//        return l;
//
//    }
//    public static NewPoint[] GetRandomPoints(int points){
//        NewPoint[] pt = new NewPoint[points]; //Point[] x = new Point[points];
//        Random position = new Random();
//        NewPoint t;
//        for(int i =0;i<points;i++) {
//            t = new NewPoint();
//            t.x = position.nextInt(100);
//            t.y = position.nextInt(100);
//            t.z = position.nextInt(100);
//            pt[i] = new NewPoint();
//            pt[i].x = t.x;
//            pt[i].y = t.y;
//            pt[i].z = t.z;
//        }
//        return pt;
//    }
//
//    public static Eucledian_Distance FindMinDistance(NewPoint[] pt, int points){
//        Eucledian_Distance x = new Eucledian_Distance();
//        x.minDistance = x.DistanceBetweenPoints(pt[0],pt[1]);
//        x.firstPoint = pt[0];
//        x.secondPoint= pt[1];
//
//        NewPoint1 firstPoint = new NewPoint1();
//        NewPoint1 secondPoint = new NewPoint1();
//
//        for(int i = 0;i<points;i++){
//            for(int j =i+1;j<points;j++){
//                double r = x.DistanceBetweenPoints(pt[i],pt[j]);
//                if(r<x.minDistance){
//                    x.minDistance = r;
//                    x.firstPoint = pt[i];
//                    x.secondPoint = pt[j];
//                }
//            }
//        }
//        return x;
//    }
//
//    public static void main(String[] args) {
//        //String points = args[0];
//        int points = 3;
//        NewPoint[] pt; //Point[] x = new Point[points];
//
//        pt = GetRandomPoints(points);
//
//        Eucledian_Distance x = new Eucledian_Distance ();
//
//        x = FindMinDistance(pt,points);
//
//        System.out.println(x.minDistance);
//        System.out.println(x.firstPoint.x);
//        System.out.println(x.firstPoint.y);
//        System.out.println(x.firstPoint.z);
//        System.out.println(x.secondPoint.x);
//        System.out.println(x.secondPoint.y);
//        System.out.println(x.secondPoint.z);
//    }
//}
//

package AlgorithmsHW.HW2;
/**
 * This program implements an algorithm that finds the number of right triangles formed from a set of points in O(n^2logn) time
 *
 * @author Shardul Dabholkar and Joe Tom Job
 */

import java.util.Scanner;

public class AnglesNew {
    public static void main(String[] args) {

        AnglesNew A = new AnglesNew();
        Scanner in = new Scanner(System.in);
        //Take the input; n = the total number of points
        Integer n = in.nextInt();
        in.nextLine();

        String[] strPoint = new String[n];

        //Take the n points
        for (int i = 0; i < n; i++) {
            strPoint[i] = in.nextLine();
        }

        String[][] strPointtwoD = new String[n][2];

        //Store n point in String 2D array
        for (int i = 0; i < n; i++) {
            strPointtwoD[i] = strPoint[i].split(" ");
        }

        int[][] points = new int[n][2];
        //Store n points in integer 2D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = Integer.parseInt(strPointtwoD[i][j]);
            }
        }

        double[][] slopeArray = new double[n][n - 1];
        //complexity is n^2
        //Calculate the slope of each point with n points. Store all the values is  [n][n-1] array. First row contains
        //values of slopes of first point with respect to other points. Second row values of slopes of second point with
        //respect to other points and so on.
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (points[i][0] != points[j][0] || points[i][1] != points[j][1]) {
                    if (points[j][0] - points[i][0] != 0) {
                        slopeArray[i][count] = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                        count++;
                    } else {
                        slopeArray[i][count] = 1000;
                        count++;
                    }
                }
            }
        }

        //complexity is n^2logn
        //Sort each row of the 2D array. each row takes(n-1)logn time. For n rows, the complexity is n^2logn
        for (int i = 0; i < n; i++) {
            A.sort(slopeArray[i], 0, slopeArray[i].length - 1);
        }

        //complexity n^2logn
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        double t = 1000;
        for (int i = 0; i < n; i++) {
            count2 = 0;
            int extend = 0;
            for (int j = 0; j < slopeArray[i].length; j++) {
                if(slopeArray[i][j]>0){
                    extend = j;
                    break;
                }
            }
//            if(slopeArray[i].length%2 == 0){
//                extend = slopeArray[i].length/2;
//            }
//            else{
//                extend = slopeArray[i].length/2+1;
//            }
//            extend = n - 1;
            for (int j = 0; j < extend; j++) {
                count3 = 0;
                double x = slopeArray[i][j];
                double y;
                if (x == 0) {
                    y = 1000;
                } else if (x == t) {
                    y = 0;
                } else {
                    y = (double) -1 / x;
                }
                int k = A.binaryS(slopeArray[i], y, 0, slopeArray[i].length - 1);
                int kl = k;
                int kr = k;
                if (k != -1) {

                    double errvl = .000001;
                    double lt = y - errvl;
                    double rt = y + errvl;

                    count2++;
                    count3++;
                    kl--;
                    while (kl >= 0 && slopeArray[i][kl] > lt && slopeArray[i][kl] < rt) {
                        count2++;
                        count3++;
                        kl--;
                    }
                    kr++;
                    while (kr < slopeArray[i].length && slopeArray[i][kr] > lt && slopeArray[i][kr] < rt) {
                        count2++;
                        count3++;
                        kr++;
                    }
                    while (j + 1 < extend && slopeArray[i][j + 1] == slopeArray[i][j]) {
                        count2 += count3;;
                        j++;
                    }
                }
            }
            count1 += count2;
        }
        System.out.println(count1);


    }

    //function to merge for merge sort
    void merge(double arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;//we added +1 here because, we are passing index and the length of array must be index+1
        int n2 = r - m;

        /* Create temp arrays */
        double L[] = new double[n1];
        double R[] = new double[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    //sort() function implements mergesort
    void sort(double arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    int binaryS(double[] a, double k, int l, int r) {
        if (l <= r) {
            int m = (l + r) / 2;

            double errvl = .000001;
            double lt = k - errvl;
            double rt = k + errvl;

//            if (lt == rt) {
//                return m;
//            }
            if (a[m] > lt && a[m] < rt) {
                return m;
            }
            else if (a[m] > k) {
                return binaryS(a, k, l, m - 1);
            } else {
                return binaryS(a, k, m + 1, r);
            }
        } else {
            return -1;
        }
    }
}

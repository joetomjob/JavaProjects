package AlgorithmsHW.HW2;
/**
 * This program implements an algorithm that finds the number of right triangles formed from a set of points in O(n^2logn) time
 *
 * @author Shardul Dabholkar and Joe Tom Job
 */

import java.util.Scanner;

public class Angles {
    public static void main(String[] args) {

        Angles A = new Angles();
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
        //complexity is O(n^2)
        //Calculate the slope of each point with n points. Store all the values is  [n][n-1] array. First row contains
        //values of slopes of first point with respect to other points. Second row contains values of slopes of second point with
        //respect to other points and so on.
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (points[i][0] != points[j][0] || points[i][1] != points[j][1]) {
                    if (points[j][0] - points[i][0] != 0) {
                        slopeArray[i][count] = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                        count++;
                    } else {
                        slopeArray[i][count] = 1000; // if the denomenator of slope is infinity, we store the slope as 1000
                        count++;
                    }
                }
            }
        }

        //complexity is O(n^2logn)
        //Sort each row of the 2D array. each row takes(n-1)log(n-1) time. For n rows, the complexity is n^2logn
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
                    extend = j;  //we find the value till we need to do binary search. we do not need to perform binary search for the whole array
                    break;
                }
            }
            for (int j = 0; j < extend; j++) {
                count3 = 0;
                double x = slopeArray[i][j];
                double y;
                if (x == 0) {
                    //if the value is 0, then we need to search for its negative reciprocal which is infinity. We stored infinity as 1000.
                    //There we need to search for the value 1000 instead of infinity.
                    y = 1000;
                } else if (x == t) {
                    y = 0; // We have saved infinity as 1000. So if value is 1000, we need to search for 0 which is the negative reciprocal of infinity
                } else {
                    y = (double) -1 / x; //calculate the negative reciprocal
                }
                int k = A.binaryS(slopeArray[i], y, 0, slopeArray[i].length - 1); //do the binary search for element
                int kl = k;
                int kr = k;
                if (k != -1) {

                    //Here we are using a delta value to check the required value lies within the delta range.
                    double errvl = .000001;
                    double lt = y - errvl;
                    double rt = y + errvl;

                    count2++;
                    count3++;
                    kl--;
                    //Binary search only tells a particular element is there in the array or not. We need to get the count of the elements.
                    //So we need to do a left scan and right scan to find all the elements which are same the searched element.
                    //In the below step a left scan is done to search for the same element
                    while (kl >= 0 && slopeArray[i][kl] > lt && slopeArray[i][kl] < rt) {
                        count2++;
                        count3++;
                        kl--;
                    }
                    kr++;
                    //In the below step a right scan is done to search for the same element
                    while (kr < slopeArray[i].length && slopeArray[i][kr] > lt && slopeArray[i][kr] < rt) {
                        count2++;
                        count3++;
                        kr++;
                    }
                    //If the following element is same the element for which negative reciprocal is to be searched, then we do not need to
                    //do a binary search again. We already have the count in count3. Just add it with count 2
                    while (j + 1 < extend && slopeArray[i][j + 1] == slopeArray[i][j]) {
                        count2 += count3;;
                        j++;
                    }
                }
            }
            //Each time add count2 to count1 to get the total count.
            count1 += count2;
        }

        //Finally count1 will have the total count of triangles that can be formed from n triangles.
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

    // Main function that sorts arr[l..r] using merge(). sort() function implements mergesort
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

    //function for binary search. This function search a value and return the index og the value
    int binaryS(double[] a, double k, int l, int r) {
        if (l <= r) {
            int m = (l + r) / 2;  //calculating the midpoint
            //Here we are using a delta value to check the required value lies within the delta range.
            double errvl = .000001;
            double lt = k - errvl;
            double rt = k + errvl;

            if (a[m] > lt && a[m] < rt) {
                return m;    //Base case : If we find the value, return the index
            }
            else if (a[m] > k) {
                return binaryS(a, k, l, m - 1); //recursive step
            } else {
                return binaryS(a, k, m + 1, r);//recursive step
            }
        } else {
            return -1;
        }
    }
}

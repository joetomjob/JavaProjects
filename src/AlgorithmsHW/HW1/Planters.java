package AlgorithmsHW.HW1;

/** This program implements an algorithm that determines whether it is possible to replant the plants so that each gets a larger planter than
 * it had initially.

 * @author Shardul Dabholkar and Joe Tom Job
 */
import java.util.Scanner;

public class Planters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Take the 2 inputs; n = no of house plants , m = extra planters
        Integer n = in.nextInt();
        Integer m = in.nextInt();
        in.nextLine();

        //take the values of n plants
        String plants = in.nextLine();

        //take the values of m extra plants
        String newplants = in.nextLine();

        //store the n values of plants and m values of extra plants in string array
        String[] plantArray = new String[n];
        String[] newplantArray = new String[n];
        plantArray = plants.split(" ");
        newplantArray = newplants.split(" ");

        //strore n values integer array "a" as well as "b"
        int a[] = new int[n];
        int b[] = new int[n + m];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(plantArray[i]);
            b[i] = Integer.parseInt(plantArray[i]);
        }

        //move m values also to "b". Therefore array "b" will have n+m values
        for (int i = 0; i < m; i++) {
            b[n + i] = Integer.parseInt(newplantArray[i]);
        }

        //Sort arrays "a" and "b" using merge sort. To sort the array "b", it will take O((n+m)log(m+n)) time because
        //length of array "b" is (n+m) and complexity of mergesort is O(nlogn)
        Planters planters = new Planters();
        planters.sort(a, 0, a.length - 1);
        planters.sort(b, 0, b.length - 1);

        int c[] = new int[n];
        int afirstIndex = 0;
        int bfirstIndex = 0;
        int k = 0;

        /*The below step take O(m+n)time. Here we compare the arrays "a" and "b". If we are able to get a plant from array "a" and place
        it in "b" then we push it into a new array "c". Finally "c" will have all the elements in "a" which were able to be moved to larger planter.*/
        while (afirstIndex < n && bfirstIndex < n + m) {
            if (a[afirstIndex] < b[bfirstIndex]) {
                c[k] = a[afirstIndex];
                k++;
                afirstIndex++;
                bfirstIndex++;
            } else {
                bfirstIndex++;
            }
        }
        int d[] = new int[k];
        //values in "c" are moved to "d". But "d" will have length of "k". k is the number of elements moved from "a" to "c"
        for (int i = 0; i < k; i++) {
            d[i] = c[i];
        }
        //If the number of elements in "d" and "a" are same, that means all elements in "a" are planted, else not.
        if(a.length != d.length){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }

    //function to merge for merge sort
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;//we added +1 here because, we are passing index and the length of array must be index+1
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

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
    void sort(int arr[], int l, int r) {
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
}

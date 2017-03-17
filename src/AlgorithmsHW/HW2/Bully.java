package AlgorithmsHW.HW2;
/**
 * This program implements an algorithm that finds total number of bullying that occurs in a line
 *
 * @author Shardul Dabholkar and Joe Tom Job
 */
import java.util.Scanner;

public class Bully {
    int counter1 = 0;

    public Bully() {
        counter1 = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Take the input; n = the total number of children waiting for the bus
        Integer n = in.nextInt();
        in.nextLine();

        //take the values of n integers which represents universally agreed upon value of a student's lunch
        String lunch = in.nextLine();

        //store the n values in string array
        String[] lunchArray = new String[n];
        lunchArray = lunch.split(" ");

        //strore n values integer array "a"
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(lunchArray[i]);
        }

        Bully b = new Bully();
        b.counter1 = b.sort(a, 0, a.length - 1);
        System.out.println(b.counter1);

    }

    //function to merge for merge sort
    int merge(int arr[], int l, int m, int r) {
        int count = 0;
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

        //if the left part contains -1, then we need to compare elements coming after the -1. So we find the index of -1 if there is any.
        for (int n = l; n < m+1; n++) {
            if(arr[n] == -1){
                i = n-l+1;
            }
        }
        int ct = 0;
        //if there is a -1 in left part of the array, then we need to insert all the elements till -1 in Left array to the final array.
        if(i>0){
            while (ct < i) {
                arr[k] = L[ct];
                ct++;
                k++;
            }
        }

        //In the below step we are merging 2 arrays. We need to sort in descending order.
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                // Here we use the logic of counting incversion. If an element is right array is greater than an element in left array,
                // we need to do "n1 - i" inversion to bring it to the correct position. The count will keep track of this value.
                count += n1 - i;
                arr[k] = R[j];
                j++;
            } else {
                if(R[j]!=-1) { // we need to do sorting only till we find -1 in the right array.
                    arr[k] = L[i];
                    i++;
                }
                else{
                    break;
                }
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
        return count;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    //sort() function implements mergesort

    int cnt = 0;

    int sort(int arr[], int l, int r) {

        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            int count = merge(arr, l, m, r);
            cnt += count;
        }
        return cnt;
    }

}

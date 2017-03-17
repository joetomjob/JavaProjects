package HW7;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class StorageOrderNewSort {

    int initialSize = 2;
    int filled = 0;
    Integer[] data = new Integer[initialSize];
    Integer[] localData;
    static int interatorPosition = 0;
    Comparator<Integer> comparator;

    //The comparator is set to the custom comparator in the constructor
    public StorageOrderNewSort(Comparator<Integer> comparator) {
        for (int index = 0; index < data.length - 1; index++) {
            data[index] = null;
        }
        this.comparator = comparator;
    }

    public void copy(Integer[] to, Integer[] from) {
        for (int index = 0; index < filled; index++) {
            to[index] = from[index];
        }

    }

    public void sort() {
        if (data.length == 1)
            return;
        localData = new Integer[filled];
        copy(localData, data);
        mergesort(0, localData.length - 1);
        copy(data, localData);
    }

    //Merge sort function used to sort the elements in the array
    void mergesort(int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergesort(l, m);
            mergesort(m + 1, r);

            // Merge the sorted halves
            merge(l, m, r);
        }
    }

    //Merges the arrays once sorting is done
    void merge(int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;//we added +1 here because, we are passing index and the length of array must be index+1
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = localData[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = localData[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (comparator.compare(L[i], R[j]) < 0) {
                localData[k] = L[i];
                i++;
            } else {
                localData[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            localData[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (j < n2) {
            localData[k] = R[j];
            j++;
            k++;
        }
    }

    public String toInteger() {
        String result = "";
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] != null)
                result = "" + index + ". " + data[index] +
                        ((index == data.length - 1) ? "." : ",\n") + result;
        }
        return result;
    }

    public boolean add(Integer e) {
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] == null) {
                data[index] = e;
                filled++;
                sort();
                return true;
            }
        }
        if (filled < data.length) {
            localData = new Integer[data.length * 2];
            copy(localData, data);
            data = localData;
            return (add(e));

        }
        return false;
    }

    public boolean remove(Integer e) {
        for (int index = 0; index < filled; index++) {
            if (data[index].compareTo(e) == 0) {
                data[index] = data[filled - 1];
                data[filled - 1] = null;
                filled--;
                sort();
                return true;
            }
        }
        return false;
    }

    public boolean contain(Integer e) {
        for (int index = 0; index < filled; index++) {
            if (data[index].compareTo(e) == 0)
                return true;
        }
        return false;
    }

    public int size() {
        return filled - 1;
    }

    public void startFromBeginning() {
        interatorPosition = 0;
    }

    public boolean hasNext() {
        return (interatorPosition < filled);
    }

    public Integer next() {

        return data[interatorPosition++];
    }

    public boolean addAll(StorageOrderNewSort c) {
        while (c.hasNext()) {
            add(c.next());
        }
        return true;
    }

    public double evaluate() {
        double result = 0;
        while (hasNext()) {
            Integer aInteger = next();
            // if (aInteger!=0) {
            result += 1.0 / aInteger;
            //}
        }
        return result;
    }

    public static void main(String args[]) {

        //We have overridden the comparator constructor
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        StorageOrderNewSort aStorageOrderNewSort = new StorageOrderNewSort(comparator);


        aStorageOrderNewSort.add(1);
        aStorageOrderNewSort.add(0);
        aStorageOrderNewSort.add(2);
        aStorageOrderNewSort.add(11);
        aStorageOrderNewSort.add(45345);
        aStorageOrderNewSort.add(24);
        aStorageOrderNewSort.add(166);
        aStorageOrderNewSort.add(3);
        aStorageOrderNewSort.add(8);
        aStorageOrderNewSort.add(4);

        aStorageOrderNewSort.add(9);
        aStorageOrderNewSort.add(456);
        aStorageOrderNewSort.add(2);
        aStorageOrderNewSort.add(65);
        aStorageOrderNewSort.add(2);
        System.out.println("aStorageOrderNewSort.evaluate(); " + aStorageOrderNewSort.evaluate());

        System.out.println(aStorageOrderNewSort);
        System.out.println("aStorageOrderNewSort.contains(a)  " + aStorageOrderNewSort.contain(0));
        System.out.println("aStorageOrderNewSort.contains(f)  " + aStorageOrderNewSort.contain(4));
        System.out.println("aStorageOrderNewSort.remove(a)  " + aStorageOrderNewSort.remove(2));
        System.out.println("aStorageOrderNewSort.remove(a)  " + aStorageOrderNewSort.remove(1));
        System.out.println(aStorageOrderNewSort);
        aStorageOrderNewSort.startFromBeginning();
        while (aStorageOrderNewSort.hasNext()) {
            System.out.println("	" + aStorageOrderNewSort.next());
        }


    }
}
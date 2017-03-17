package HW7;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
//Changes made to check exception.In evaluate function,1.0 is chaged to 1 to check exception. An exception is added in evaluate function(commented). If it is uncommented the program will run even if error is thrown in evaluate function
//Assertion added in add function. If we add values less than 0, it will throw exception
public class StorageOrderNewGenerics<E extends Comparable<E>> {

    int initialSize = 2;
    int filled = 0;
    E[] data;
    E[] localData;
    static int interatorPosition = 0;
    Comparator<E> comparator;
    Class<E> eclass;

    public E[] arrayInitialize(int size) {
        E[] x = (E[]) Array.newInstance(eclass, size);
        return (x);
    }

    public StorageOrderNewGenerics(Comparator<E> comparator, Class<E> eclass) {
        //data = (E[]) Array.newInstance(initialSize);
        this.eclass = eclass;
        data = arrayInitialize(initialSize);
        for (int index = 0; index < data.length - 1; index++) {
            data[index] = null;
        }
        this.comparator = comparator;
    }

    public void copy(E[] to, E[] from) {
        for (int index = 0; index < filled; index++) {
            to[index] = from[index];
        }
    }

    public void sort() {
        if (data.length == 1)
            return;
        localData = arrayInitialize(filled);
        copy(localData, data);
        mergesort(0, localData.length - 1);
        copy(data, localData);
    }

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

    void merge(int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;//we added +1 here because, we are passing index and the length of array must be index+1
        int n2 = r - m;

        /* Create temp arrays */
        E[] L = arrayInitialize(n1);
        E R[] = arrayInitialize(n2);

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

    public boolean add(E e) {
        assert 0<=Integer.parseInt(e.toString()):-1;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] == null) {
                data[index] = e;
                filled++;
                sort();
                return true;
            }
        }
        if (filled < data.length) {
            localData = arrayInitialize(data.length * 2);
            copy(localData, data);
            data = localData;
            return (add(e));

        }
        return false;
    }

    public boolean remove(E e) {
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

    public boolean contain(E e) {
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

    public E next() {

        return data[interatorPosition++];
    }

    public boolean addAll(StorageOrderNewGenerics<? super E> c) {
        while (c.hasNext()) {
            add((E)c.next());
        }
        return true;
    }

    public double evaluate() {
        double result = 0;
        while (hasNext()) {
            try {
                E aInteger = next();
                // if (aInteger!=0) {
                result += 1.0 / Integer.parseInt(aInteger.toString());
                //}
            } catch (Exception ex) {
                System.out.println("The input type is not integer");
            }

        }
        return result;
    }

    public static void main(String args[]) {

        Comparator<String> comparator = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        StorageOrderNewGenerics<String> aStorageOrderNewGenerics = new StorageOrderNewGenerics<String>(comparator, String.class);

        try {
            aStorageOrderNewGenerics.add("asd");
            aStorageOrderNewGenerics.add("sdf");
            aStorageOrderNewGenerics.add("sfs");
            aStorageOrderNewGenerics.add("dasd");
            aStorageOrderNewGenerics.add("adsd");
            aStorageOrderNewGenerics.add("Aaa");
//            try {
//                aStorageOrderNewGenerics.add(Integer.parseInt("abcd"));
//            } catch (NumberFormatException ex) {
//                System.out.println("Please enter a valid integer");
//            }

            //System.out.println("aStorageOrderNewGenerics.evaluate(); " + aStorageOrderNewGenerics.evaluate());

            System.out.println(aStorageOrderNewGenerics);
            System.out.println("aStorageOrderNewSort.contains(a)  " + aStorageOrderNewGenerics.contain("aaa"));
//            System.out.println("aStorageOrderNewSort.contains(f)  " + aStorageOrderNewGenerics.contain(4));
//            System.out.println("aStorageOrderNewSort.remove(a)  " + aStorageOrderNewGenerics.remove(2));
//            System.out.println("aStorageOrderNewSort.remove(a)  " + aStorageOrderNewGenerics.remove(1));
            System.out.println(aStorageOrderNewGenerics);
            aStorageOrderNewGenerics.startFromBeginning();
            while (aStorageOrderNewGenerics.hasNext()) {
                System.out.println("	" + aStorageOrderNewGenerics.next());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}

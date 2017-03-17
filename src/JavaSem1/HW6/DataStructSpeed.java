package JavaSem1.HW6;

import java.lang.reflect.Array;
import java.util.Arrays;

/** This class is designed for speed. The fetching of an elemnt in the object of this class is done in very less time than the other classes
 * @author Praneeth Rao and Joe Tom Job
 */
public class DataStructSpeed<E extends Comparable<E>> implements interf<E> {
    int counter = -1;
    int ARRAYSIZE = 10;
    E[] arr;
    E[] arraytemp;

    public DataStructSpeed(Class<E> eClass) {
        arr = (E[]) Array.newInstance(eClass, ARRAYSIZE);
        arraytemp = (E[]) Array.newInstance(eClass, ARRAYSIZE);
    }

    //This function is used to sort elements in the object in order
    public void Sort(E[] a) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int ob = i;
            for (int j = i + 1; j < length; j++) {
                if(a[j] != null) {
                    if (a[j].compareTo(a[ob]) < 0) {

                        ob = j;
                    }
                }
            }
            E small = a[ob];
            a[ob] = a[i];
            a[i] = small;
        }
        arr = a;
    }

    @Override
    //funtion used to insert an element in the object
    public void insert(E a) {
        boolean arrayfilled = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = a;
                arrayfilled = false;
                break;
            }
        }
        if (arrayfilled) {
            arr = Arrays.copyOf(arr, arr.length * 2);
            insert(a);
        }
        Sort(arr);
    }

    @Override
    //funtion used to remove an element in the object
    public void remove(E a) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(a)) {
                arr[i] = null;
            }
        }
    }

    @Override
    //checks whether an element is present in the object and returns true or false
    public boolean contain(E a) {

        int count = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i]!=null){
                arraytemp[count] = arr[i];
                count+=1;
            }
        }
        int  L = 0;
        int U = count-1;
        int mid;
        while(L <= U) {
            mid = (L+U)/2;
            if(a.compareTo(arraytemp[mid]) < 0){
                U = mid-1;
            }
            else if (a.compareTo(arraytemp[mid]) > 0){
                L = mid + 1;
            }
            else {
                return true;
            }
            }
            return false;

        }

    @Override
    //this functions returns the size of the object
    public int size() {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                size = size + 1;
            }
        }
        return size;
    }

    @Override
    //this function checks whether any element is present in the next location. if yes returns true else false
    public boolean hasNext() {

        while ((counter + 1) < arr.length) {
            if (arr[counter + 1] != null) {
                counter++;
                return true;
            } else if (arr[counter + 1] == null) {
                counter++;
            }
        }
        return false;
    }

    @Override
    //this function returns the next element in the object
    public E next() {
        return arr[counter];
    }

    @Override
    //this function reset the counter to start so that we can start from beginning of the object
    public void StartfromBeginnig() {
        counter = -1;
    }

    @Override
    //this function adds all the elements of one object to another object
    public void addAll(E[] a){
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    //This function fetch the elements in the object
    public E[] fetcharray(){
        return arr;

    }

}

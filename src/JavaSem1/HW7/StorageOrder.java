package HW7;

import java.lang.reflect.Array;
import java.util.Arrays;

/*changes made : 1) The initialize variable is set to 2 instead of 1. Otherwise if it is 1,the length of array -1 will be be 0 in add function and the check will be false
                 2) Added the logic to double the size array when it reaches the limit int the add function.
                 3) Since dividing by zero leads to answer as infinity, an  additional check is added to check whether the variable is 0 in the evaluate function
                 4) In hasnext function the check is modified to return (interatorPosition < filled); instead of return (interatorPosition <= filled);
                 5) In the contain() function the <= symbol changed to < since it will go out of bounds of the array if an element is not present*/
public class StorageOrder {

    int initialSize = 2;
    int filled = 0;
    Integer[] data = new Integer[initialSize];
    Integer[] localData;
    static int interatorPosition = 0;

    public StorageOrder() {
        for (int index = 0; index < data.length - 1; index++) {
            data[index] = null;
        }

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
        for (int index = 0; index < localData.length - 1; index++) {
            for (int walker = 0; walker < localData.length - index - 1; walker++) {
                Integer left = localData[walker];
                Integer right = localData[walker + 1];
                if (left.compareTo(right) > 0) {
                    Integer tmp = localData[walker];
                    localData[walker] = localData[walker + 1];
                    localData[walker + 1] = tmp;
                }
            }
        }
        copy(data, localData);
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
        for (int index = 0; index < data.length-1; index++){
            if (data[index] == null) {
                data[index] = e;
                filled++;
                sort();
                return true;
            }
        }
        if (filled < data.length) {
            localData = new Integer[data.length*2];
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

    public boolean addAll(StorageOrder c) {
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
        StorageOrder aStorageOrder = new StorageOrder();
        aStorageOrder.add(1);
        aStorageOrder.add(0);
        aStorageOrder.add(2);
        System.out.println("aStorageOrder.evaluate(); " + aStorageOrder.evaluate());

        System.out.println(aStorageOrder);
		System.out.println("aStorageOrder.contains(a)  " + aStorageOrder.contain(0));
		System.out.println("aStorageOrder.contains(f)  " + aStorageOrder.contain(4));
		System.out.println("aStorageOrder.remove(a)  " + aStorageOrder.remove(2));
		System.out.println("aStorageOrder.remove(a)  " + aStorageOrder.remove(1));
		System.out.println(aStorageOrder);
		aStorageOrder.startFromBeginning();
		while ( aStorageOrder.hasNext() ) {
		       System.out.println("	" + aStorageOrder.next() ) ;
		}

    }
}
package JavaSem1.HW6;
import java.util.Arrays;
/** This class acts as a set. We cannot enter duplicate elements to the object of this class.
 * @author Praneeth Rao and Joe Tom Job
 */
public class DataStructSet<E> implements  interf<E>{
    int counter = -1;
    E[] arr = (E[])new Object[10];

    @Override
    //funtion used to insert an element in the object
    public void insert(E a) {
        if(!contain(a)){
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
        }
    }

    @Override
    //funtion used to remove an element in the object
    public void remove(E a) {

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null && arr[i].equals(a)){
                arr[i] = null;
            }
        }
    }

    @Override
    //checks whether an element is present in the object and returns true or false
    public boolean contain(E a) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null && arr[i].equals(a)){
                return true;
            }
        }
        return false;
    }

    @Override
    //this functions returns the size of the object
    public int size() {
        int size = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=null){
                size = size+1;
            }
        }
        return size;
    }

    @Override
    //this function checks whether any element is present in the next location. if yes returns true else false
    public boolean hasNext() {

        while((counter+1)<arr.length){
            if(arr[counter+1] != null){
                counter++;
                return true;
            }
            else if(arr[counter+1]==null){
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

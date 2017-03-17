package testing;

/**
 * Created by Admin on 02-11-2016.
 */
public class quicksort {

    public static void main(String[] args) {
        int k[] = {1,2,90,6,3,2,12};
        quicksort q = new quicksort();
        q.quicksort(k,0,k.length-1);
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i]);
            System.out.print("\t");
        }
    }
    public void quicksort(int[] k, int start, int end){
        if(start < end){
            int index = partition(k,start,end);
            quicksort(k,start,index-1);
            quicksort(k,index+1,end);
        }
    }
    public int partition(int[] k, int start, int end){
        int index = start;
        int pivot = k[end];
        for (int i = start; i < end; i++) {
            if(k[i]<=pivot){
                int temp = k[i];
                k[i] = k[index];
                k[index] = temp;
                index = index + 1;
            }
        }
        k[end] = k[index];
        k[index] = pivot;
        return index;
    }
}

package testing;

/**
 * Created by Admin on 29-10-2016.
 */
public class QuickSortSample {
    public static void main(String[] args) {
        int[] x = {9,22,5,1,7,7,7,8,3,54,2};
        QuickSortSample ob = new QuickSortSample();
        ob.sort(x,0,x.length-1);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            System.out.print("\t");
        }
    }
    void sort(int[] x,int start,int end){
        if(start<end){
            int index = partition(x,start,end);
            sort(x,start,index-1);
            sort(x,index+1,end);
        }
    }

    int partition(int[] y, int start, int end){
        int pivot = y[end];
        int pind = start;
        for (int i = start; i < end; i++) {
            if(y[i]<=pivot){
                int k = y[i];
                y[i] = y[pind];
                y[pind] = k;
                pind = pind+1;
            }
        }
        y[end] = y[pind];
        y[pind] = pivot;
        return pind;
    }
}

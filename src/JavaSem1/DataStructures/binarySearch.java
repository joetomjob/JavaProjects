package DataStructures;

/**
 * Created by Admin on 15-12-2016.
 */
public class binarySearch {
    public static final int FAILURE = -1;
    private static int bsearch(int[] i, int left, int right, int findMe){
        if (left > right){
            return FAILURE;
        }
        int mid = (left+right)/2;
        if (i[mid]==findMe){
            return mid;
        }
        else if (findMe > i[mid]){
            return bsearch(i,mid+1,right,findMe);
        }
        else{
            return bsearch(i,left,mid-1,findMe);
        }
    }

    public static void main(String[] args) {
        int[] i = {1,2,3,4,4,5,6,7,7,8,9};
        System.out.println(bsearch(i,0,i.length-1,7));
    }
}

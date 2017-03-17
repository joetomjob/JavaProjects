package IB;

/**
 * Created by Admin on 22-01-2017.
     */
public class squareroot {
    public int sqrt(int a) {
        int result = 0;
        if(a==0 || a==1){
            return a;
        }
        int start = 1;
        int end = a;
        int mid;
        while(start <= end){
            mid = (start+end)/2;
            if(mid == a/mid && a%mid ==0){
                return mid;
            }
            else if(mid <= a/mid){
                start = mid+1;
                result = mid;
            }
            else{
                end = mid-1;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        squareroot s = new squareroot();
        int k = s.sqrt(2147483647);
        System.out.println(k);
    }
}

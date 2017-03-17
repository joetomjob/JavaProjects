package IB;

import java.util.*;

public class maxsumcontiguoussubarray { //O(n^2)   Brute force algorithm
    // DO NOT MODFIY THE LIST.

    public int maxSubArray_Kadens(final List<Integer> a) {// O(n)
        int ans = Integer.MIN_VALUE, sum =0;
        for(int i = 0;i<a.size();i++){
            sum += a.get(i);
            ans = Math.max(ans,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return ans;
    }

    public int maxSubArray_DivideConquer(final List<Integer> a, int size) {//recursion O(nlog(n))

        return 0;
    }

    public int maxSubArray_second(final List<Integer> a) {
        int ans = Integer.MIN_VALUE;
        for (int i =0;i<a.size();i++){
            int sum = 0;
            for (int j =1; j<=a.size();j++){
                if(i+j>a.size()){
                    break;
                }
                sum += a.get(i+j-1);
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }

    public int maxSubArray(final List<Integer> a) {  //O(n^3)
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= a.size(); i++) {
            for(int j =0;j<a.size();j++){
                if(i+j>a.size()){
                    break;
                }
                int sum = 0 ;
                for(int k=j;k<j+i;k++){
                    sum += a.get(k);
                }
                ans = Math.max(sum,ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList x = new ArrayList();
        maxsumcontiguoussubarray r = new maxsumcontiguoussubarray();
        x.add(-12);
        x.add(-1);
        x.add(-2);
        x.add(-3);
        x.add(-19);
        x.add(-9);
        x.add(-3);

        int l = r.maxSubArray(x);
        System.out.println(l);
        int m = r.maxSubArray_second(x);
        System.out.println(m);
        int n = r.maxSubArray_Kadens(x);
        System.out.println(n);
    }
}


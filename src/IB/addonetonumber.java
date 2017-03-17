package IB;

import java.util.*;

public class addonetonumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int num;
        int carry = 1;
        int size = a.size();
        for (int i = size-1; i >= 0; i--) {
            num = a.get(i);
            num = num + carry;
            carry = 0;

            if (num == 10) {
                num = 0;
                carry = 1;
            }
            a.set(i,num);
        }
        ArrayList r = new ArrayList();
        if(carry == 1){
            r.add(carry);
        }
        for (int i : a){
            if (i==0 && r.size() ==0){
                continue;
            }
            else{
                r.add(i);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        ArrayList x = new ArrayList();
        addonetonumber r = new addonetonumber();
        x.add(0);


        ArrayList y = r.plusOne(x);
        for (int i = 0; i < y.size(); i++) {
            System.out.println(y.get(i));
        }
    }
}
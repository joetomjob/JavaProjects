package IB;


import java.util.ArrayList;

public class IBArray1 {
    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (B>=A.size()){
            B = B%A.size();
        }
        int r=0;
        for (int i = 0; i < A.size(); i++) {
            if ((i + B) < A.size()) {
                ret.add(A.get(i + B));
                r = i+1;
            } else {
                ret.add(A.get(i - r));

            }
        }

        return ret;
    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(14);
        A.add(5);
        A.add(14);
        A.add(34);
        A.add(42);
        A.add(63);
        A.add(17);
        A.add(25);
        A.add(39);
        A.add(61);
        A.add(97);
        A.add(55);
        A.add(33);
        A.add(96);
        A.add(62);
        A.add(32);
        A.add(98);
        A.add(77);
        A.add(35);


        int B = 56;

        IBArray1 rotat = new IBArray1();
        ArrayList<Integer> C = new ArrayList<Integer>();
        C = rotat.rotateArray(A, B);
        for (int i = 0; i < C.size(); i++) {
            System.out.print(C.get(i));
            System.out.print("\t");
        }

    }
}

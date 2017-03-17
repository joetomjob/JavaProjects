package ctci;

/**
 * Created by Admin on 3/14/2017.
 */
public class permutation_ArrayQ2 {
    public static void main(String[] args) {
        int[] letters = new int[128];
        String s = "joetomjob";
        for (int i = 0; i <128 ; i++) {
            System.out.print(letters[i]);
            System.out.print('\t');
        }
        System.out.print('\n');
        char[] s_array = s.toCharArray();
        for(char k : s_array){
            System.out.print(k);
            System.out.print('\t');
        }
        System.out.print('\n');
        for (int i = 0; i < s.length() ; i++) {
            System.out.print((int)s.charAt(i));
            System.out.print('\t');
        }
        System.out.print('\n');
        for (int i = 0; i < s.length(); i++) {
            System.out.print(Character.getNumericValue(s_array[i]));
            System.out.print('\t');
        }
        System.out.print(Character.getNumericValue('#'));
    }
}

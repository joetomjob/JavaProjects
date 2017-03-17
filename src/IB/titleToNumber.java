package IB;

/**
 * Created by Admin on 22-01-2017.
 */
public class titleToNumber {
    public int titleToNumber(String a){
        int[] val = new int[26];
        for(int i = 0; i < 26;i++){
            val[i] = i+1;
        }
        int product = 1;
        int result = 0;
        for(int  i =a.length()-1; i>=0 ;i--){
            char c = a.charAt(i);
            result += product*val[c-'A'];
            product *= 26;
        }
        return result;
    }
    public static void main(String[] args){
        titleToNumber t = new titleToNumber();
        int k = t.titleToNumber("ABD");
        System.out.println(k);
    }
}

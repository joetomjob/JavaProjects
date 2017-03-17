package IB;

/**
 * Created by Admin on 22-01-2017.
 */
public class reversewords {
    public String reverseWords(String a) {
        String[] result = a.trim().split("\\s+");
        String r = "";
        for(int i=result.length-1;i>=0;i--){
            r += result[i];
        }
        return r;
    }

    public static void main(String[] args) {
        reversewords r = new reversewords();
        String k = r.reverseWords("This is Sky");
        System.out.println(k);
    }
}

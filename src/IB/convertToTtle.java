package IB;

/**
 * Created by Admin on 22-01-2017.
 */
public class convertToTtle {
    public String convertToTitle(int a) {

        StringBuffer s = new StringBuffer();
        if (a==0){
            return s.toString();
        }

        while(a>=26){
            int r = (a)%26;
            a = (a-1)/26;
            if(r == 0){
                s.append((char)('A'+25));
            }
            else{
             s.append((char)('A'+r-1));
            }
        }
        if(a>0){
            s.append((char)('A'+a-1));
        }
        s.reverse();
        return s.toString();
    }

    public static void main(String[] args) {
        convertToTtle t = new convertToTtle();
        String k = t.convertToTitle(468096);
        System.out.println(k);


    }
}

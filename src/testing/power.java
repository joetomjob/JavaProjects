package testing;

/**
 * Created by Admin on 29-12-2016.
 */
public class power{
    public int powerofno(int x, int n){
        if (n<=1){
            return x;
        }
        else{
            if(n%2==0) {
                n = (int) n / 2;
                return powerofno(x, n) * powerofno(x, n);
            }
            else{
                n = (int) ((n-1) / 2);
                return powerofno(x, n)* powerofno(x, n) * x;
            }
        }
    }

    public static void main(String[] args) {
        int x = 5;
        int n = 4;
        power p = new power();
        int f = p.powerofno(x,n);
        System.out.println(f);

    }
}

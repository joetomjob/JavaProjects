/**
 * Created by Admin on 25-08-2016.
 */
import java.util.Scanner;
public class JMJ {
    public static void main(String[] args) {
        System.out.println("Jesus Mary Joseph");
//        String S ="07:05:45PM";
//        System.out.println(S.substring(S.length()-2,S.length()));
//        System.out.println(S.substring(0,2));

        Scanner S = new Scanner(System.in);
        int[]arr = new int[3];
        System.out.println("Enter 1st line");
        String S1 = S.nextLine();
        String[] arrStr = S1.split(" ");
        for(int i=0;i<3;i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int[]arr2 = new int[arr[0]];
        System.out.println("Enter the second line");
        String S2 = S.nextLine();
        String[] arrStr2 = S2.split(" ");
        for(int i=0;i<arr[0];i++){
            arr2[i] = Integer.parseInt(arrStr2[i]);
        }
        int[] arr3 = new int[arr[2]];
        for(int i=0;i<arr[2];i++)
        {
            arr3[i] = S.nextInt();
        }
        for(int i=0;i<arr[1];i++){
            int temp = arr2[arr[0]-1];
            for(int j =0;j<arr[0]-1;j++){
                arr2[arr[0]-j-1] = arr2[arr[0]-j-2];
            }
            arr2[0]=temp;
        }
        for(int i=0;i<arr[2];i++)
        {
            System.out.println(arr2[arr3[i]]);
        }
    }

}

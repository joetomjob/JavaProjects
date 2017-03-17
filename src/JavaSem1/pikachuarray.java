/**
 * Created by Admin on 05-09-2016.
 */
public class pikachuarray {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 5, 10, 10, 25, 25, 25, 50};
        int value = 53;

        int arrsmall2[] = new int[9];
        int counter = 9;

        for(int i = 0; i < (int) Math.pow(2,arr.length); i++)
        {
            int arrsmall[] = new int[arr.length];
            int cnt = 0;
            int sum = 0;
            for(int j = 0; j < arr.length; j++)
            {
                if ((i & (1 << j)) > 0) //logic to go through each element of the power set of the given set.
                {
                    arrsmall[cnt] = arr[j];
                    cnt++;
                    sum = sum+arr[j];
                }
            }
            if(sum==value)
            {
                if(cnt<counter)
                {
                    counter = cnt;
                    arrsmall2 = arrsmall;
                }
            }
        }
        System.out.print(value + "  :"+"\t");
        for(int i=0;i<counter;i++)
        {
            System.out.print(arrsmall2[i]);
            System.out.print("\t");

            //System.out.print("\n");
        }
    }
}

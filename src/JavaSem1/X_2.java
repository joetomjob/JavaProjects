public class X_2 {
/*
While if_1() is called for the first time, the index is 2. First line "1. 2" is printed.Then the next line is false, since
  ++index = 3 and 3!=2. then else if condition is checked. --index is 2 and is not equal to 3. There also the condition fails.
  Then for next condition, index++ == 3 is checked. Here index++ will change index to 3 only after comparing.Therefore here 2==3 is checked
  and result is false.Therefore index is changed to 3 the else part is executed. and "4. 3" is printed.

  While if_1() is called for the second time, the index is 4. First line "1. 4" is printed.Then the next line is false, since
  ++index = 5 and 5!=2. then else if condition is checked. --index is 4 and is not equal to 3. There also the condition fails.
  Then for next condition,index++ == 3 is checked. Here index++ will change index to 5 only after comparing.Therefore here 4==3 is checked
  and result is false.Therefore index is changed to 5 the else part is executed. and "4. 5" is printed.
 */
    public static void if_1(int index)	{
        System.out.println("1. " + index );
        if ( ++index == 2 )
            System.out.println("2. " + index );
        else if ( --index  == 3 )
            System.out.println("3. " + index );
        else if ( index++  == 3 )
            System.out.println("4. " + index );
        else
            System.out.println("4. " + index );
    }

/*Here while loop_1 is called, n= 4 and k = 5. First n<k is checked. Here 4<5 and condition is satisfied. We enter into while loop and
 value of n is printed as "1. n==4". Then n<k+4 is checked. Here 4<5+4 is checked and result is true. . We
 enter to the next while loop. n is changed to 5. value of n is then printed as "2.  n == 5". Then n<k is checked. 5<5 is checked and
 the result is false. Then value of n is then printed as "3.  n == 5--------". Then again 5<5+4 is checked and result is true. n is
  incremented by 1 and value of n is printed as "2.  n == 6". Then n<k is checked. 6<5 is false and the innermost while loop is not
  executed. The value of n is printed as "3.  n == 6--------". Then n<k+4 is checked. Here 6<5+4 is true and the value of n is
  incremented to 7 and value of n printed as "2.  n == 7". The n<k is checked. 7<5 is false and the value of n is printed as
  "3.  n == 7--------". Then n<k+4 is checked. Here 7<5+4 is true and the value of n is
  incremented to 8 and value of n printed as "2.  n == 8". The n<k is checked. 8<5 is false and the value of n is printed as
  "3.  n == 8--------".Then n<k+4 is checked. Here 8<5+4 is true and the value of n is
  incremented to 9 and value of n printed as "2.  n == 9". The n<k is checked. 9<5 is false and the value of n is printed as
  "3.  n == 9--------". Then n<k+4 is checked and 9<5+4 is false. We get out of that while loop. n is incremented and n is now 10.
  Then n<k is checked 10<5 is false and we come out of that while loop also. And we are done.
 */
    public static void loop_1(int n, int k)	{
        label1:
        while ( n < k )  {
            System.out.println("1. n == " + n);

            while ( n < k + 4 )  {
                n++;
                System.out.println("2.  n == " + n);
                label2:
                while ( n < k )	{
                    if ( n > 2 )
                        continue label1;
                    else
                        continue label2;
                }
                System.out.println("3.  n == " + n + "--------");
            }
            n++;
        }
    }

    /*This function is executed finally. 2 parameters are there and they are n=0 and k = 4.
    Here for for loop first index is set to 0. then we check whether index<( n > k ? k : n ). Here we can check
    whether n>k. that is 0>4 which is false. Therefore in this conditional statement, output is n. and n is 0. Therefore
    while checking index<( n > k ? k : n ), this will result in false. Therefore it will not enter into the for loop.*/

    public static void loop_2(int n, int k)	{
        for ( int index = 0; index < ( n > k ? k : n ); index ++ )	{
            int rennerle = k;
            while ( rennerle > 0 )	{
                if ( ( index - 1 ) % rennerle == 0 )
                    break;
            }
        }
    }
    public static void main(String args[]) {
        /*First if_1(2) is called. */
        if_1(2);

        /*Secondly if_1(4) is called. */
        if_1(4);

        /*Thirdly loop_1(4, 5) is called. */
        loop_1(4, 5);

        /*Finally loop_2(0, 4) is called. */
        loop_2(0, 4);
    }
}
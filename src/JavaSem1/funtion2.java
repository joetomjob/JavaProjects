
public class funtion2 {
	public static void main(String[] args)
	{
		double sum = 0;
		//The function is Sine function and sin(0.1) = 0.09983341664682815
		double delta = 8.333333333110371/100000000; // delta value is taken for pair(1,2). Therefore output will be printed for the pair (2,3). The code exits.
		double currentvalue = 0;
		double absolutevalue=0;
		for(int n = 0; n <=2; n++)
		{	
			for(int i = 0;i<=n;i++)
			{
				sum = sum + ((Math.pow(-1, n)/(Factorial((2*n)+1)))*(Math.pow(0.1, ((2*n)+1))));
				currentvalue = sum+((Math.pow(-1, (n+1))/(Factorial((2*(n+1))+1)))*(Math.pow(0.1, ((2*(n+1))+1))));				
			}
			absolutevalue = Math.abs(sum-currentvalue);
			if(absolutevalue < delta)
			{
				System.out.println(absolutevalue*100000000);
				break;
			}
		}		
	}
	public static int Factorial(int fac)
	{
		int res = 1;
		for(int j=2;j<=fac;j++)
		{
			res = res*j;
		}
		return res;
	}
}
	

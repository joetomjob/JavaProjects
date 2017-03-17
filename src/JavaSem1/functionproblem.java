public class functionproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double sum = 0;
				
		for(int i = 0; i <=10; i++)
		{
			sum = sum + ((Math.pow(-1, i)/(Factorial((2*i)+1)))*(Math.pow(.1, ((2*i)+1))));
			System.out.println(sum);
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


public class PiPrecision
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		double diff = 0;
		double delta = .0001;
		if(delta>0)
		{
			for(int i = 0;i<=100000;i++)
			{
				double sum = 0;
				double sumnext = 0;
				for(int j=0;j<=i;j++)
				{
					sum = sum+(Math.pow(-1,j)/((2*j)+1));
					sumnext = sum+(Math.pow(-1,(j+1))/((2*(j+1))+1));
				}			
				diff = Math.abs(sumnext-sum);
				if(diff<delta)
				{
					System.out.println("pi("+delta+")=  "+sum*4);
					break;
				}
			}
		}
		else
		{
			System.out.println("Delta cannot be less than 0");
		}
	}
}


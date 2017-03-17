public class PikachuSmall {
	public static void main(String[] args) 
	{
		int arr[] = new int[]{1,2,5,10,10,25,25,25,50};
		int arrsmall[] = new int[9];
		
		int value = 53; // change the value here
		int sum = 0;
		int m =0;
		for (int i = 0; i<arr.length; i++) 
		{
	        for (int j = 0; j < arr.length; j++)
	        {
	            if (arr[i] > arr[j]) 
	            {
	                int k = arr[i];
	                arr[i] = arr[j];
	                arr[j] = k; 
	            }
	        }
	    }

		for(int i = 0;i<9;i++)
		{			
			if(sum+arr[i] <= value)
			{
				sum = sum+arr[i];
				arrsmall[m] = arr[i];
				m = m+1;
			}			
			if(sum == value)
			{				
				System.out.print(sum +"\t"+"==");
				for(int k=0;k<m;k++)
				{
					System.out.print("\t");
					System.out.print(arrsmall[k]);					
				}
				break;
			}
			
		}
		if(sum != value)
		{
			System.out.println("No");
		}
		
	}
}



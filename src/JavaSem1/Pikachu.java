
public class Pikachu {
	public static void main(String[] args) 
	{
		int arr[] = new int[]{1,2,5,10,10,25,25,25,50};
		int value = 0;
		int sum = 0;
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
			}			
			if(sum>0 && sum == value)
			{				
				System.out.println("Yes");
				break;
			}
			
		}
		if(sum != value || sum ==0)
		{
			System.out.println("No");
		}
		
	}
}


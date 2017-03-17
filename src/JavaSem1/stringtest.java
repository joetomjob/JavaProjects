
public class stringtest {
	  static String[] aText = {
			"Oh let the sun beat down upon my face, stars to fill my dream "
		 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = aText;
		//Length of the array
		int sum = 0;
		int nolines = 0;
		for(int i=0;i<a.length;i++)
		{
			sum = sum+a[i].length();			
		}
		System.out.println("Total length of all characters in the array = " + sum);//Print the total length of all characters in the array
		
		//Number of lines starting with "We" or "Wh"
		for(int i=0;i<a.length;i++)
		{
			if(a[i].startsWith("Wh") || a[i].startsWith("We"))
			{	
				nolines+=1;				
			}			
		}	
		System.out.println("Number of lines starting with 'Wh' or 'We' = " + nolines); // Print the number of lines starting with "Wh" or "We"
		
		//Lines with "On" in it
		int lineswithon=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i].toLowerCase().contains("on"))
			{					
				lineswithon += 1;
			}			
		}
		System.out.println("Total number of lines with 'on' in it = "+lineswithon); // Print the lines with "on" in it
		
		//How often does on appear		
		int noofon=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length();j++)
			{
				if(a[i].charAt(j) == 'o')
				{
					if(a[i].charAt(j+1) == 'n' && j+1 < a[i].length())
					{
						noofon = noofon +1;
					}
				}
			}
		}		
		System.out.println("Total number of 'on' in the array string = " + noofon); //Print the no of on in the string

		//convert all upper case characters to lower case and all lower case to upper case
		
		String[] b = new String[a.length];
		for(int i =0;i<b.length;i++){
			b[i] = "";
		}
		for(int i=0;i<a.length;i++)
		{
			char[] k = a[i].toCharArray();
			for(int j=0;j<k.length;j++)
			{				
				if(Character.isUpperCase(k[j]))
				{
					k[j] = Character.toLowerCase(k[j]);
				}
				else if(Character.isLowerCase(k[j]))
				{
					k[j] = Character.toUpperCase(k[j]);
				}				
			}
			for(Character c : k)
			{				
				b[i] += c.toString();
			}
		}
		System.out.println("");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(b[i]);			
		}		
	}

}

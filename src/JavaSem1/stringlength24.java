
public class stringlength24 {
	  static String[] aText = {
			"Oh let the sun beat down upon my face, stars to fill my dream ",
			"I am a traveler of both time and space, to be where I have been ",
			"To sit with elders of the gentle race, this world has seldom seen ",
			"They talk of days for which they sit and wait and all will be revealed ",
			"",
			"Talk and song from tongues of lilting grace, whose sounds caress my ear ",
			"But not a word I heard could I relate, the story was quite clear ",
			"Oh, oh. ",
			"",
			"Oh, I been flying... mama, there ain't no denyin' ",
			"I've been flying, ain't no denyin', no denyin' ",
			"",
			"All I see turns to brown, as the sun burns the ground ",
			"And my eyes fill with sand, as I scan this wasted land ",
			"Trying to find, trying to find where I've been. ",
			"",
			"Oh, pilot of the storm who leaves no trace, like thoughts inside a dream ",
			"Heed the path that led me to that place, yellow desert stream ",
			"My Shangri-La beneath the summer moon, I will return again ",
			"Sure as the dust that floats high in June, when movin' through Kashmir. ",
			"",
			"Oh, father of the four winds, fill my sails, across the sea of years ",
			"With no provision but an open face, along the straits of fear ",
			"Ohh. ",
			"",
			"When I'm on, when I'm on my way, yeah ",
			"When I see, when I see the way, you stay-yeah ",
			"",
			"Ooh, yeah-yeah, ooh, yeah-yeah, when I'm down... ",
			"Ooh, yeah-yeah, ooh, yeah-yeah, well I'm down, so down ",
			"Ooh, my baby, oooh, my baby, let me take you there ",
			"",
			"Let me take you there. Let me take you there",
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

import java.util.Scanner;


public class caseexample {
	public static void main(String[] args) {
		
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter text: ");
//		String x = input.nextLine();
//
//		switch (x) {
//		case "start":
//			System.out.println("Machine Started");
//			break;
//		case "stop":
//			System.out.println("Machine Started");
//			break;
//		default:
//			System.out.println("Not Recognized");
//			break;
//		}
		int k=2;
		if(k++ == 3)
		{
			System.out.println("y 2");
		}

		if(++k == 3)
		{
			System.out.println("y 1");
		}
		System.out.println(k);

	}
}

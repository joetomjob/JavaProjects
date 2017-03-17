import java.util.Scanner;			// why do we need this line?

public class X_4HW {

    static String inputForScanners[] = {
            "a b c d e f g", 			// delimiter = one whitespace. case 0
            "a   b c    d   e f   g", 		// delimiter = one or more whitespaces. case 1
            "a1b2c3d4e5f6g", 			// delimiter = one number between 1 and 9. case 2
            "a11b2c3d4e5f10g111h", 			// delimiter = one number between 1 and 11. case 3
            "a123b123c23456d23456e1f222123g",	// delimiter = one or more number between 1 and 9. case 4
            "a23b123c23456d23456e111f222123g", 	// delimiter = two or more number between 1 and 9. case 5 to be finished
            "a123b1c12d1e12f12g", 			// delimiter = numbers in series from 1 to 3. case 6 to be finished
            "a111b11c1d1e1fg", 			// delimiter = zero up to 3 1's. case 7
            "aenebenecenedeneeenefeneg", 		// delimiter = ene. case 8
            "brcsdtexfyg", 				// delimiter = r, s, t, x, y. case 9
            "b1c2d9e8f5g", 				// delimiter = 1 through 9, but not 4-7. case 10 to be finished
            "bAcBdCeDfZg", 				// delimiter = lowerCase. case 11
    };

    public static void main(String args[]) {
        for (int index = 0; index < inputForScanners.length; index ++ ) {
            Scanner aScanner = new Scanner(inputForScanners[index]);
            switch ( index ) {
                case 0: aScanner.useDelimiter(" ");
                    break;
                case 1: aScanner.useDelimiter("\\s+");
                    break;
                case 2: aScanner.useDelimiter("[1-9]");
                    break;
                case 3: aScanner.useDelimiter("(1[01]|[1-9])");
                    break;
                case 4: aScanner.useDelimiter("[1-9]+]");
                    break;
                case 5: aScanner.useDelimiter("[1-9]{2,}");
                    break;
                case 6: aScanner.useDelimiter("1?2?3?");
                    break;
                case 7: aScanner.useDelimiter("1{0,3}");
                    break;
                case 8: aScanner.useDelimiter("ene");
                    break;
                case 9: aScanner.useDelimiter("[r|s|t|x|y]");
                    break;
                case 10: aScanner.useDelimiter("[1-3]|[8-9]");
                    break;
                case 11: aScanner.useDelimiter("[a-z]");
                    break;
                // add your code here ..
                // here
                // you can not modify anything below this line
                default: aScanner = new Scanner(System.in);
            }

            while ( aScanner.hasNext() )
                System.out.println(index + ".	" + aScanner.next() );
        }

    }
}
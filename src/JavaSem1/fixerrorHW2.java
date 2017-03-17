class fixerrorHW2 {
	public static void method(String id, String literal, String aNewString) {
		System.out.println("method!" + id + ". " + (literal == aNewString));
	}

	public static void main(String args[]) {
		String aString = "123";
		String bString = "123";
		int number = 3;

		/*
		 * here the output is false because "a" and 123" is concatenated to one
		 * string and is compared with "aString". Since both are not
		 * same('a.123' not equal to '123'), the result is false
		 */
		//1 String literal created
		//Garbage collector can clear the string "a. 123" can be cleared in the next line.
		System.out.println("a.	" + "123" == aString); // GC can clear "a. 123"
														// in the next line

		/*
		 * The operation in parenthesis occurs first. Here the string "123" is
		 * compared with "aString". The value of aString is 123. SInce both are
		 * same, the result is true. The result is then concatenated with the
		 * string 'b.'
		 */
		//1 String literal created
		//Garbage collector can clear the string "b. true" can be cleared in the next line.
		System.out.println("b.	" + ("123" == aString)); // GC can clear
														// "b. true" in the next
														// line

		/*
		 * Calculation occurs from left to right. Here integer 123 is considered
		 * as string since 'c.' and 'aString' are strings. All of them are
		 * concatenated
		 */
		//1 String literal created
		//Garbage collector can clear the string "c. 123123" can be cleared in the next line.
		System.out.println("c.	" + aString + 123);

		/*
		 * Here 123 and number are integers. Calculation happens from left to
		 * right. Here since the leftmost element : "d." is a string.Therefore
		 * the following elements '123' and 'number' are considered as strings.
		 * 'aString' is already string. While adding these, all are
		 * concatenated.
		 */
		//1 String literal created
		//Garbage collector can clear the string "d. 1233123" can be cleared in the next line.
		System.out.println("d.	" + 123 + number + aString);

		/*
		 * Here values in parenthesis is calculated first. Calculation occurs
		 * from left to right. 123 and number are considered as integers and
		 * they are added. Then the result is considered as a string and is
		 * concatenated with aString.Then the result is concatenated with the
		 * string "e."
		 */
		//1 String literal created
		//Garbage collector can clear the string "e. 126123" can be cleared in the next line.
		System.out.println("e.	" + (123 + number + aString));

		/*
		 * Here the operation in parenthesis occurs first and calculation
		 * happens from left to right. Integer 123 is added with empty string.
		 * Therefore the result is a string. The resulting string is added with
		 * integer 'number' which result in concatenation of previous result
		 * with number.Then the resulting string is concatenated with aString.
		 */
		//1 String literal created
		//Garbage collector can clear the string "f. 1233123" can be cleared in the next line.
		System.out.println("f.	" + (123 + "" + number + aString));

		/*
		 * Here multiplication occurs first. Since in the calculation order,
		 * multiplication comes before addition. Therefore, 123 * 3 happens
		 * first and the result is 3. Then from left to right,the string 'g. '
		 * is concatenated with the previous result(369). Then this is
		 * concatenated with 'aString'
		 */
		//1 String literal created
		//Garbage collector can clear the string "g. 369123" can be cleared in the next line.
		System.out.println("g.	" + 123 * number + aString);

		/*
		 * Here division occurs first. Since in the calculation order, division
		 * comes before addition. 123/3 = 41. then 'h. ' is concatenated with
		 * the result and finally with 'aString'
		 */
		//1 String literal created
		//Garbage collector can clear the string "h. 41123" can be cleared in the next line.
		System.out.println("h.	" + 123 / number + aString);

		/*
		 * Initially error was being thrown at this line since we missed the
		 * "parenthesis" for "123-number".Addition operation happens first.
		 * Addition happens for the strings. 123 and and number are considered
		 * as string and they are added. After that, subtraction happens and
		 * strings cannot be subtracted. So it throws error. But when we put
		 * parenthesis, the operation in parenthesis occurs first and here it is
		 * subtraction. Then the result is treated as a string and is added to
		 * other string
		 */
		//1 String literal created
		//Garbage collector can clear the string "i. 120123" can be cleared in the next line.
		System.out.println("i.	" + (123 - number) + aString);

		/*
		 * The function 'method' compares 2 strings. The 2 strings are passed as
		 * arguments.Here in the function method(), 2 stringsare compared using
		 * == operator
		 */

		// ""+"xyz" will result in "xyz".When both are compared, they are
		// pointing to the same memory space.Therefore the result is true
		// 2 String literal created in function. xyz created here and method!1. in function.
		//Garbage collector will not clear the string xyz in next line because it is used in next lines.
		method("1", "xyz", "" + "xyz");

		// Here xy, z and xyz are stored in different memory spaces. Therefore
		// while comparing, the result is false
		// 3 string created (xy created here. xy added to z to create a new string and method!2. in created in function)
		//Garbage collector can clear the newly created string xy after the next line
		method("2", "xyz", (new String("xy")).intern() + "z");

		// Here "x"+"yz" results in string "xyz". This result is compared to
		// "xyz" and both will point to same memory space.Thus, result is true.
		// 1 String literal created in function.xyz already exists in string constant pool.method!3 created in function
		//Garbage collector will not clear the string xyz after the next line because it is used in next lines.
		method("3", "xyz", "x" + "yz");

		// "x"+"y"+"z" results in "xyz". This result is compared to "xyz" and
		// both will point to same memory space.Thus, result is true.
		// 1 String literal created in function. xyz already exists in string constant pool.method!4 created in function
		//Garbage collector will not clear the string xyz after the next line because it is used in next lines.
		method("4", "" + "x" + "y" + "z", "xyz");

		/*
		 * Here "x" is stored in one memory space and "y"+"z" is stored as "yz"
		 * in another memory space. Therefore while comparing, the pointers are
		 * not pointing to the same memory space.Thus the result is false
		 */
		// 4 Strings created (3 here and one in function, method!5 created in function)
		//Garbage collector can clear the newly created strings  x and z after the the next line
		method("5", new String("x") + "y" + new String("z"), "xyz");

		/*
		 * Here x is a character and y is a string. First the operation in
		 * parenthesis occurs. Therefore character x is added to string y
		 * resulting in "xy".This string is added to z to get "xyz". This is
		 * compared to "xyz" and the result is true.
		 */
		// 1 String literal created in function. method!7 is created in function
		//Garbage collector can clear the string xyz after the next line.
		method("7", ('x' + "y") + "z", "xyz");

		// 8 strings are getting displayed from lines marked a) to i)
		// 12 strings are getting displayed from lines marked 1 to 7


	}
}
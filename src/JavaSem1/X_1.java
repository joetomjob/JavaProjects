public class X_1 {

    public static boolean a()	{ 	return false;		}
    public static boolean c()	{ 	return false;		}
    public static boolean e()	{ 	return true;		}
    public static String b()	{ 	return "b";		}
    public static String d()	{ 	return "d";		}
    public static String f()	{ 	return "f";		}
    public static String g()	{ 	return "g";		}

    public static void questionMcolon()	{

        /*Initially the program threw error since parenthesis were missing. String was concantenated which resulted in error*/

        /*Function a is called. a() returns false. Therefore function c() is called. c() returns false.
        Therefore the output is false. Hence the result is "1: false"*/
        System.out.println("1: " +  (a() ? b() : c()) );

        /* Here we execute b() if !a() is true. a() returns false. Therefore !a() is true. Hence b() is executed
        and b() returns the string 'b'. Thus the result is "2: b"*/
        System.out.println("2: " +  (! a() ? b() : c()) );

        /*Here a() or e() is checked. a() returns false and e() returns true. Therefore a()||e() is true and since
        it is true, b()+g() will be executed. b() returns the string b and g() returns the string g. and b()+g()
        results in the concantenation of the strings b and g. Hence the result 3: bg*/
        System.out.println("3: " +  (a() || e() ? b() + g() : c() ));

        /*Here the operation in innermost parenthesis happens first. e()?f():g() is evaluated. Since e() returns true
        f() is called. f() returns the value "f". Here the result of e()?f():g()is string"f". Then operation in next
        parenthesis occurs.That is c()?d():(e()?f():g()) = c()? d():"f". c() returns false. Therefore this results to
        "f".Then the final calculation. a()?b():"f". a() returns false and the final answer is "f". Therefore
        the result is 4. f*/
        System.out.println("4: " +  (a() ? b() : (c() ? d() : (e() ? f() : g())) ));

        /*Here calculation happens from left to right. Operation a()?b():c().... occurs first. a() return false and
        thus c()?d():e()... is executed. c() returns false and e() ? f() : g() is executed. e() return true and
        f() is executed. f() return the string "f". Thus the result is "5: f"*/
        System.out.println("5: " +  (a() ? b() : c() ? d() : e() ? f() : g() ));

        /*Here the operation in innermost parenthesis happens first. Therefore c()?d():e()... happens first.
        c() returns false. Therefore e()?f():g() is computed. e() return true and f() is called. f() returns
        the string "f". Then !a()?b():"f" is computed. a() returns false and !a() is true. Therefore b() is called.
        b() returns the string "b". Therefore the result is "6: b"*/
        System.out.println("6: " +  (! a() ? b() : ( c() ? d() : e() ? f() : g() ) ));

        /*Here the operation in innermost parenthesis happens first. Therefore !c()?d():e()... happens first.
        c() returns false and !c() is true. Therefore d() is executed and d() returns string "d".
         Then !a() and !e() is computed. a() reurn false and !a() is true. e() returns true and !e() is false.
         Therefore !a() && !e() is false. Therefore ( ! c() ? d() : e() ? f() : g() ) is executed and as we computed
         the result earlier, the reult is string "d". Hence the output is "7: d"*/
        System.out.println("7: " +  (! a() && ! e()  ? b() : ( ! c() ? d() : e() ? f() : g() ) ));
    }
    public static void main(String args[]) {
        questionMcolon();
    }
}
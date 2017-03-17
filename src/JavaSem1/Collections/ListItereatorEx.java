package Collections;


import java.util.Stack;
import java.util.ListIterator;
import java.util.Collection;

public class ListItereatorEx {


    // private Collection<String> palindrom;
    private Stack<String> palindrom;

    private Collection<String> fill(String words[]) {
        palindrom  = new Stack<String>();
        for (String id : words ) {
            palindrom.push(id);
        }
        return palindrom;
    }

    private Collection<String> leftRight()	{
        ListIterator<String> aListIterator = palindrom.listIterator(2);
        String s  = aListIterator.next();
        System.out.println("s = " + s );
        aListIterator.set("ZZ top");
        return palindrom;
    }

    public static void main(String args[])	{
        Collection<String> aStack;
        String theOnes[] = { "a", "b", "c", "d" };
        ListItereatorEx o = new ListItereatorEx();

        aStack = o.fill(theOnes );
        System.out.println("1: " + aStack );

        aStack = o.leftRight();
        System.out.println("2: " + aStack );

    }
}

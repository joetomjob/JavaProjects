package JavaSem1.TreeSet;
import java.util.*;
public class mytest{
    public static void main(String[] args) {
        HpTreeSet t = new HpTreeSet();
        t.add("joe");
        t.add("tom");
        t.add("job");
        t.add("rose");
        t.add("mary");
        t.add("mariamma");
        t.add("joseph");
        t.add("arupara");
        int s= t.size();
        System.out.println(s);
        boolean x = t.contains("joe");
        //t.clear();
        boolean y = t.isEmpty();
        System.out.println("g");

        TreeSet tt = new TreeSet();
        t.add(null);
        System.out.println(t);
    }

}

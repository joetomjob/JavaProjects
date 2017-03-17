package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.*;
/**
 * Created by Admin on 26-11-2016.
 */
public class testing {
    public static void main(String[] args) {
        List<String> a  = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            a.add(String.valueOf(i));
        }
        for (int i = 0; i <4 ; i++) {
            System.out.println(a.get(i));
        }
        for (String x : a) {
            System.out.println(x);
        }
        ListIterator<String> x = a.listIterator();
        while (x.hasNext()){
            System.out.println(x.next());
        }

        Iterator<String> y = a.listIterator();
        ArrayList k= new ArrayList();
        k.add(1);
        k.add('a');
        k.add(null);
        k.add(2,3);
        k.remove(1);
        System.out.println(k);
    }
}

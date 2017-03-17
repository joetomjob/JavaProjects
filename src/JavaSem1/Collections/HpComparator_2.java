package Collections;

import java.util.*;

public class HpComparator_2 {

    public static void sort(List list, Comparator c) {
        Object anArray[] = list.toArray();
        // Arrays.sort(a, c);		/////// this is the trick
        // http://www.cs.rit.edu/~hpb/Jdk5/api/java/util/ListIterator.html

        for (int index=0; index<anArray.length - 1; index++)     {
            for (int walker=0; walker<anArray.length - index - 1; walker++)  {
                Object left =  anArray[walker];
                Object right =  anArray[walker+1];
                if ( c.compare(left,  right ) > 0 )        {
                    Object tmp = anArray[walker];
                    anArray[walker] = anArray[walker + 1];
                    anArray[walker+1] = tmp;
                }
            }
        }


        ListIterator i = list.listIterator();
        for (int j=0; j<anArray.length; j++) {
            i.next();
            i.set(anArray[j]);
        }
    }

}

package JavaSem1.HW6;

/** This class implements the main function used to test all the new classes implemented
 * @author Praneeth Rao and Joe Tom Job
 */
public class main {
    public static void main(String args[]){
        /*DataStruct for 1st question*/
        DataStruct<String> r = new DataStruct<String>();
        r.insert("datastructtest1");
        r.insert("datastructtest3");
        r.insert("datastructtest2");
        r.insert("datastructtest4");
        r.remove("datastructtest1");
        while(r.hasNext()){
            System.out.println(r.next());
        }

        /*DataStruct Set*/
        DataStructSet<String> d = new DataStructSet<String>();

        for(int i = 0;i<20;i++){
            d.insert("String"+i);
        }
        d.insert("joe");
        d.insert("Hi");
        d.insert("String6");
        d.insert("String7");

        d.remove("String3");
        d.remove("String4");
        d.remove("String5");

        System.out.println(d.contain("String5"));
        System.out.println(d.size());

        d.StartfromBeginnig();
        while(d.hasNext()){
            System.out.println(d.next());
        }

        //Data Structure Order
        DataStructOrder<String> s = new DataStructOrder<String>(String.class);
        s.insert("bsa");
        s.insert("asa");
        s.insert("rsa");
        s.insert("gsa");

        s.insert("zsa");
        s.insert("ysa");
        s.insert("ksa");
        s.remove("ksa");

        s.insert("lsa");

        //Data Structure Speed
        DataStructSpeed<String> m = new DataStructSpeed<String>(String.class);
        m.insert("dfg");
        m.insert("dfgdf");
        m.insert("gd");
        m.insert("gfd");

        m.insert("vfhgf");
        m.insert("ert");
        m.insert("gh");
        m.remove("hgh");
        while(m.hasNext()){
            System.out.println(m.next());
        }
        System.out.println(m.contain("ysa"));
        System.out.println(m.contain("ert"));

        //example of addall
        DataStructOrder<String> t = new DataStructOrder<String>(String.class);
        DataStructSpeed<String> k = new DataStructSpeed<String>(String.class);


        t.addAll(s.fetcharray());
        k.addAll(s.fetcharray());
        k.addAll(s.fetcharray());

        //print all the elemrnts in k.(after copying elemnts from order to speed)
        k.StartfromBeginnig();
        while(k.hasNext()){
            System.out.println(k.next());
        }

        DataStructOrder<Integer> j = new DataStructOrder<Integer>(Integer.class);
        DataStructSpeed<Integer> l = new DataStructSpeed<Integer>(Integer.class);
        j.insert(1);
        j.insert(2);
        j.insert(3);
        l.addAll(j.fetcharray());
        while (j.hasNext()){
            l.next();
        }

    }


}

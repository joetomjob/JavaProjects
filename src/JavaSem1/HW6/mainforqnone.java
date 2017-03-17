package JavaSem1.HW6;

/** This class implements the main function used to test all the new classes implemented
 * @author Praneeth Rao and Joe Tom Job
 */
class mainforqnone {
    public static void main(String[] args) {
        /*DataStruct for 1st question*/
        DataStruct r = new DataStruct();
        r.insert("datastructtest1");
        r.insert("datastructtest3");
        r.insert("datastructtest2");
        r.insert("datastructtest4");
        r.remove("datastructtest1");
        while(r.hasNext()){
            System.out.println(r.next());
        }
    }
}

package JavaSem1.HW6;

/** This interface is used for all the class to implement the basic fetaures of a data structure
 * @author Praneeth Rao and Joe Tom Job
 */
interface interf<E> {
    public void insert(E a);

    public void remove(E a);

    public boolean contain(E a);

    public int size();

    public boolean hasNext();

    public E next();

    public void StartfromBeginnig();

    public void addAll(E[] a);
}

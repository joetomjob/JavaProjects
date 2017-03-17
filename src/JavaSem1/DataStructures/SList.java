package DataStructures;

/**
 * Created by Admin on 15-12-2016.
 */

class Listnode {
    Object item;
    Listnode next;

    public Listnode(Object item, Listnode next) {
        this.item = item;
        this.next = next;
    }

    public Listnode(Object item) {
        this(item, null);
    }
}

public class SList {
    private Listnode head;
    private int size;

    public SList(){
        head = null;
        size = 0;
    }
    public void insert_front(Object item){
        head = new Listnode(item,head);
        size++;
    }
    public boolean equals(SList other){
        if(size != other.size){
            return false;
        }
        Listnode n1 = head;
        Listnode n2 = other.head;

        while(n1 != null){
            if(!n1.item.equals(n2.item)){
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Listnode l1 = new Listnode(1, null);
        Listnode l2 = new Listnode(2, l1);
        Listnode l3 = new Listnode(3, l2);
        Listnode l4 = new Listnode(4, l3);

        SList l5 = new SList();
        l5.insert_front(11);
        l5.insert_front(12);
        l5.insert_front(13);
        l5.insert_front(14);
        l5.insert_front(15);
        System.out.println(l5);



    }
}


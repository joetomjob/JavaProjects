package DataStructures;

/**
 * Created by Admin on 01-12-2016.
 */
class DListNode{
    Object item;
    DListNode next;
    DListNode prev;

//    public DListNode(Object item ,DListNode next){
//
//    }
}

class DList{
    private DListNode head;
    private DListNode tail;

    public DList(){
        head = null;
        tail = null;
    }
    public void remove_tail(){ //removes only if there are atleast 2 elements in the Dlist
        tail.prev.next = null;
        tail = tail.prev;
    }

    public void add_front(Object item){

        if (head == null){
//            head = DListNode(item,head)
        }
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DList d = new DList();

    }
}

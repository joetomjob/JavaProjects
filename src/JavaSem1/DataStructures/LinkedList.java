package DataStructures;

/**
 * Created by Admin on 01-12-2016.
 */
class ListNode {
    Object item;
    ListNode next;

    public ListNode(Object item, ListNode next) {
        this.item = item;
        this.next = next;
    }

    public ListNode(Object item) {
        this(item, null);
    }

    public void insertafter(int item){
        next = new ListNode(item,next);
    }

    public ListNode nth_item(int position){
        if (position == 1){
            return this;
        }
        else if((position < 1)|| next == null){
            return null;
        }
        else{
            return next.nth_item(position-1);
        }
    }
}

class Slist{ // to keep track of the head and size of Linked List
    private ListNode head;
    private int size;

    public Slist(){
        head = null;
        size = 0;
    }

    public void insert_front(Object item){
        head = new ListNode(item,head);
        size++;
    }

    public void delete_front(){
        if (head != null){
            head = head.next;
            size--;
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);


        System.out.println(l1.item);
        System.out.println(l2.item);
        System.out.println(l1.item);
        System.out.println(l2.next.item);
        System.out.println(l3.next.item);
        System.out.println(l4.next.next.next.item);

        l3.insertafter(10);
        l4.next.insertafter(20);
        System.out.println("next");
        System.out.println(l1.item);
        System.out.println(l2.next.item);
        System.out.println(l3.next.item);
        System.out.println(l4.next.next.next.item);

        System.out.println("next");
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3.next.next);
        System.out.println(l3.next);
        System.out.println(l3);
        System.out.println(l4);
        System.out.println(l4.nth_item(4));

        System.out.println("next");
        Slist l5 = new Slist();
        l5.insert_front(11);
        l5.insert_front(12);
        l5.insert_front(13);
        l5.insert_front(14);
        l5.insert_front(15);
        System.out.println(l5);

    }
}

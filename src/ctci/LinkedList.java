package ctci;

/**
 * Created by Admin on 3/15/2017.
 */
class Node{
    int a;
    Node next = null;

    public Node(int k){
        a = k;
    }
    void appendToTail(int r){
        Node n = new Node(r);
        Node l = this;
        while (l.next != null){
            l = l.next;
        }
        l.next = n;
    }

    Node deleteNode(Node head, int d){
        if (head.a == d){
            return head.next;
        }
        Node k = head;
        while (k.next != null){
            if(k.next.a == d){
                k.next = k.next.next;
                return head;
            }
            k = k.next;
        }
        return head;
    }
}
public class LinkedList {
}

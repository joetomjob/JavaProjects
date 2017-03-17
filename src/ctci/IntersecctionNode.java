package ctci;

/**
 * Created by Admin on 3/15/2017.
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class IntersecctionNode {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(1);
        ListNode g = new ListNode(1);
        ListNode h = new ListNode(1);
        ListNode i = new ListNode(1);
        ListNode j = new ListNode(1);
        ListNode k = new ListNode(1);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        e.next = f;
        f.next = g;

        h.next = i;
        i.next = j;
        j.next = k;

        IntersecctionNode l = new IntersecctionNode();
        ListNode r = l.getIntersectionNode(a,h);
        System.out.println(r.val);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}


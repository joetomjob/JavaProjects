package testing;

/**
 * Created by Admin on 11-02-2017.
 */

class Stk {
    int[] k;
    int top;
    int max;

    public Stk(int a) {
        max = a;
        k = new int[max];
        top = -1;
    }

    public void add(int a) {
        if (!isFull()) {
            k[++top] = a;
        }
    }

    public int remove() {
        int r = k[top];
        top--;
        return r;
    }

    public int peek() {
        return k[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max - 1);
    }
}


public class Stack {
    public static void main(String[] args) {
        Stk n = new Stk(10);
        n.add(3);
        n.add(6);
        n.add(8);
        n.add(9);
        n.add(5);

        while (!n.isEmpty()){
            System.out.println(n.remove());
        }

    }
}

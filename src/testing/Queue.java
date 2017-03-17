package testing;

class Qu{
    int[] Que;
    int front;
    int rear;
    int size;
    int len;
    public Qu(int a){
        size = a;
        Que = new int[size];
        front = -1;
        rear = -1;
        len = 0;
    }
    public boolean isEmpty(){
        return (rear == -1);
    }
    public boolean isFull(){
        return (rear == size-1);
    }
    public void add(int a){
        if(rear == -1){
            rear = 0;
            front = 0;
            Que[rear] = a;
        }
        else if(rear+1 < size){
            Que[++rear] = a;
        }
        len++;
    }

    public int remove(){
        int a = Que[front];
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else{
            front++;
        }
        len--;
        return a;
    }
}
public class Queue {
    public static void main(String[] args) {
        Qu n = new Qu(10);
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

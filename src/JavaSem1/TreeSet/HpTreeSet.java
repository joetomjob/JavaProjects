package JavaSem1.TreeSet;

import java.util.*;
import java.util.TreeSet;

class Node<E extends Comparable> {

    E item;

    Node left;
    Node right;
    Node parent;

    Node() {
    }

    Node(Object o) {
        this.item = (E) o;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    boolean add(Object p) {
        boolean rValue = false;
        try {
            this.item = (E) p;
            this.left = null;
            this.right = null;
            rValue = true;
        } catch (Exception ex) {
            rValue = false;
        }
        return rValue;
    }

    boolean contains(Object p) {
        boolean rValue = true;
        return rValue;
    }

    public void parse(Object allObjects[]) {

    }

    public String toString() {
        String str = this.item.toString();
        return str;
    }

    public int Compare(Object o) {
        E obj = (E) o;
        return this.item.compareTo(obj);
    }
}

class myStack {
    private int maxSize;
    private Node[] stackArray;
    private int top;

    public myStack(int s) {
        maxSize = s;
        stackArray = new Node[s];
        top = -1;
    }

    public void push(Node j) {
        stackArray[++top] = j;
    }

    public Node pop() {
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}


class HpIterator implements Iterator {

    private Node next;

    myStack newstack;

    public HpIterator(Node root) {
        newstack = new myStack(300000);
        while (root != null) {
            if (root.item != null) {
                newstack.push(root);
            }
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !newstack.isEmpty();
    }

    public Object next() {
        Node node = newstack.pop();
        Object result = node.item;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                newstack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}

public class HpTreeSet extends TreeSet {

    Node root = new Node();
    boolean isContains = false;
    boolean addReturnValue = false;
    int size;

    public HpTreeSet() {
        this.root = new Node();
        size = 0;
    }

    public void init() {

    }

    public boolean add(Object o) {
        boolean rValue = false;
        if (root.item == null) {
            root.add(o);
            root.parent = null;
            rValue = true;
            size += 1;
        } else {
            rValue = addObject(root, o);
            addReturnValue = false;
        }
        return rValue;
    }

    private boolean addObject(Node node, Object o) {
        Node newnode = new Node(o);
        if (node.Compare(o) > 0) {
            if (node.left == null) {
                node.left = newnode;
                node.left.parent = node;
                addReturnValue = true;
                size += 1;
            } else {
                addObject(node.left, o);
            }
        } else if (node.Compare(o) < 0) {
            if (node.right == null) {
                node.right = newnode;
                node.right.parent = node;
                addReturnValue = true;
                size += 1;
            } else {
                addObject(node.right, o);
            }
        } else {
            addReturnValue = true;
        }
        return addReturnValue;
    }

    public void parse() {
    }

    public String toString() {
        return "";
    }

    public void clear() {
        this.root = new Node();
        this.size = 0;
    }

    public boolean contains(Object o) {
        boolean rValue = false;
        if (root == null) {
            return false;
        } else if (root.item == null) {
            return false;
        } else {
            rValue = traverse(root, o);
            isContains = false;
        }
        return rValue;
    }

    private boolean traverse(Node node, Object o) {
        if (!isContains) {
            if (node.item.compareTo(o) > 0) {
                if (node.left != null) {
                    traverse(node.left, o);
                }
            }
            else if (node.item.compareTo(o) < 0) {
                if (node.right != null) {
                    traverse(node.right, o);
                }
            }
            else if (node.item.compareTo(o) == 0) {
                isContains = true;
            }
        }
        return isContains;
    }

    public boolean isEmpty() {
        boolean rValue = false;
        if (root.item == null) {
            rValue = true;
        }
        return rValue;
    }

    public int size() {
        //int totalsize = sizeOfTree(root);
        return size;
    }

    private int sizeOfTree(Node node) {
        int sizeTree = 0;
        if (node == null) {
            return 0;
        } else if (node.item == null) {
            return 0;
        } else {
            int leftht = sizeOfTree(node.left);
            int rightht = sizeOfTree(node.right);
            sizeTree = leftht + rightht + 1;
        }
        return sizeTree;
    }

    public Iterator iterator() {
        HpIterator treeIterator = new HpIterator(root);
        return treeIterator;
    }

}
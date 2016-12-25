package algorithms;


public class LinkedList {
    public Node root;
    public Node end;
    public class Node {
        public Object data;
        public Node next, prev;
    }
    public LinkedList(Object data) {
        root = new Node();
        end = root;
        this.root.data = data;
        this.root.next = null;
        this.root.prev = null;
    }
    public void insert(Node v, Object data) {
        Node k = new Node();
        k.data = data;
        k.next = v.next;
        k.prev = k;
        v.next = k;
    }
    public void print() {
        for(Node i = root; i != null; i = i.next) {
            System.out.print(i.data + " ");
        }
    }
}

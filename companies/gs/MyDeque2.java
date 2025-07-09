package companies.gs;

class Node {
    int value;
    Node next;
    Node prev;

    Node (int value){
        this.value = value;
    }
}

public class MyDeque2 {

    private Node head, tail;
    private int size;

    public void addFront(int val){
        Node node = new Node(val);
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addRear(int val){
        Node node = new Node(val);
        if(tail == null){
            head = tail = node;
        }else{
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int removeFront(){
        if(head == null){
            return -1;
        }
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }else{
            head.prev = null;
        }

        size--;
        return val;
    }

    public int removeRear(){
        if(tail == null){
            return -1;
        }

        int val = tail.value;
        tail = tail.prev;
        if(tail == null){
            head = null;
        }else{
            tail.next = null;
        }

        size--;
        return val;
    }

    public int getFront(){
        if(head == null){
            return -1;
        }
        return head.value;
    }

    public int getRear(){
        if(tail == null){
            return -1;
        }
        return tail.value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}

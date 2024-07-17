package crackingcodinginterview.linkedlists;

public class LinkedList {

    Node head;

    public LinkedList(){
        this.head = null;
    }

    //Add node to end of the linkedlist
    public void addNode(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
        }else{
            Node current  = head;

            while(current.next!=null){
                current = current.next;
            }

            current.next = newNode;
        }


    }

    //Remove node with a specific data
    public void removeNode(int data){
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }

        if (head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next!=null && current.next.data!=data){
            current = current.next;

        }

        if (current.next ==null){
            System.out.println("Data not found in the list");
        }else{
            current.next = current.next.next;
        }


    }


    //Check if linkedlist contains a certain data
    public boolean contains(int data){
        if (head ==null){
            return false;
        }

        Node current  = head;

        while(current!=null){
            if (current.data ==data){
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}

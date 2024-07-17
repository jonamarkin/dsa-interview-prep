package crackingcodinginterview.linkedlists;

public class NthToLast {

    /*

    Implement an algorithm to find the nth to last element of a singly linked list.
     */

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(2);
        linkedList.addNode(4);
        linkedList.addNode(3);
        linkedList.display();


        System.out.println(nthToLast(linkedList, 2).data);

    }

    /*
    Use two pointers
    Make both pointers point to the head of the list
    Move the one of the pointers(say the first) to the nth position or nth element

    Now move both pointers steadily one step at a time
    When the first pointer reaches the end, the second will be at the nth position
     */
     static Node nthToLast(LinkedList linkedList, int nth){

        if (linkedList.head==null || nth<=0){
            return null;
        }

        Node firstPointer  = linkedList.head;
        Node secondPointer = linkedList.head;

        for (int i=0; i<nth; i++){
            if (firstPointer.next!=null){
                firstPointer = firstPointer.next;
            }
        }

        while(firstPointer.next!=null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return secondPointer;
    }
}

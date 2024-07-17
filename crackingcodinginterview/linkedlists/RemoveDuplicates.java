package crackingcodinginterview.linkedlists;

import java.util.HashSet;

public class RemoveDuplicates {

    /*
    Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?
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
        removeDuplicates(linkedList);
        removeDuplicatesNoBuffer(linkedList);

    }

    public static void removeDuplicates(LinkedList linkedList){

        Node head = linkedList.head;

        if (head ==null){
            return;
        }

        HashSet<Integer> seen = new HashSet<>();

        Node current = head;
        Node prev = null;

        while(current!=null){
            if (seen.contains(current.data)){
                prev.next = current.next;
            }else {
                seen.add(current.data);
                prev = current;
            }

            current = current.next;
        }

       linkedList.display();
    }

    /*
    use two pointers

    Set the first pointer to the head and start the while loop
    Set the next pointer(runner) to the head as well and start the inner while loop
    For each iteration of the runner check if its next data is equal to the current data
    If true skip it and set the runner to point to two steps ahead (next.next)

    If false then set the runner to the next simply

    Come out of that loop and increment the current to the next

    the loop repeats this way until the end
     */

    public static void removeDuplicatesNoBuffer(LinkedList linkedList){

        Node current = linkedList.head;

        while(current!=null){
            Node runner  = current;
            while(runner.next!=null){
                if (runner.next.data == current.data){
                    runner = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }

        linkedList.display();
    }
}

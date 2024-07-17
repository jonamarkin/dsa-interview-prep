package crackingcodinginterview.linkedlists;

public class DetectCycle {

    /*

    Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
     */

    public static void main(String[] args) {

    }


    static Node detectCycle(Node head) {
        Node n1 = head;
        Node n2 = head;

        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;

            if (n1 == n2) {
                // return n2;
                break;
            }
        }

        if (n2.next == null) {
            return null;
        }

        n1 = head;

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2;
    }
}

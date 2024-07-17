package crackingcodinginterview.linkedlists;

public class DeleteNodeInMiddle {

    /*
    Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
     */

    public static void main(String[] args) {

    }

    /*
    First check if it is a valid node ie Not null and its next is not null as well

    Then copy the content of its next node into it which eventually removes it from the linked list
     */
    public static void deleteNodeInMiddle(Node node){
        if (node ==null ||node.next==null){
            return;
        }

        Node nexNode = node.next;
        node.data = nexNode.data;
        node.next = nexNode.next;
    }
}

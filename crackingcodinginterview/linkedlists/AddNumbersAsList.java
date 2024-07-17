package crackingcodinginterview.linkedlists;

public class AddNumbersAsList {

    /*
    You have two numbers represented by a linked list, where each node contains a single digit.
    The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
     */

    public static void main(String[] args) {
        LinkedList firstList = new LinkedList();
        firstList.addNode(1);
        firstList.addNode(2);
        firstList.addNode(3);

        firstList.display();

        LinkedList secondList = new LinkedList();

        secondList.addNode(2);
        secondList.addNode(4);
        secondList.addNode(3);

        secondList.display();

        addLists(firstList, secondList);
    }


    public static void addLists(LinkedList first, LinkedList second){
        Node headFirst = first.head;
        Node headSecond = second.head;

        if (headFirst==null || headSecond==null){
            return;
        }

        StringBuilder sumFirst= new StringBuilder(String.valueOf(headFirst.data));
        StringBuilder sumSecond = new StringBuilder(String.valueOf(headSecond.data));

        while(headFirst.next!=null){
            sumFirst.append(headFirst.next.data);
            headFirst = headFirst.next;
        }

        while(headSecond.next!=null){
            sumSecond.append(headSecond.next.data);
            headSecond = headSecond.next;
        }

        int total  = Integer.parseInt(sumSecond.toString()) + Integer.parseInt(sumFirst.toString());
        System.out.println(total);

        LinkedList linkedList = new LinkedList();

        String totalString = String.valueOf(total);

        System.out.println(totalString);

        for (int i=0; i<totalString.length(); i++){
            System.out.println();
            linkedList.addNode(totalString.charAt(i)-'0');
        }

        linkedList.display();
    }

}

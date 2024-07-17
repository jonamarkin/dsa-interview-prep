package crackingcodinginterview.linkedlists;

public class AddNumbersAsList {

    /*
    You have two numbers represented by a linked list, where each node contains a single digit.
    The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
     */

    public static void main(String[] args) {
        LinkedList firstList = new LinkedList();
        firstList.addNode(9);
        firstList.addNode(9);
        firstList.addNode(3);

        firstList.display();

        LinkedList secondList = new LinkedList();

        secondList.addNode(2);
        secondList.addNode(4);
        secondList.addNode(3);

        secondList.display();

        addLists(firstList, secondList);

        addLists_SecondSol(firstList, secondList);
    }


    /*
    Wrong solution because the numbers are stored in reverse order but this solution assumes the numbers are stored in normal order
     */
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



    public static void addLists_SecondSol(LinkedList first, LinkedList second){

        Node result = addListsRecursive(first.head, second.head, 0);

        LinkedList linkedList = new LinkedList();
        linkedList.head = result;

        System.out.println("result");
        linkedList.display();
    }


    static Node addListsRecursive(Node node1, Node node2, int carry){
        if (node1==null && node2 ==null && carry==0){
            return null;
        }

        Node resultNode = new Node(carry);
        int value = carry;

        if (node1!=null){
            value+= node1.data;
        }

        if (node2!=null){
            value+= node2.data;;
        }

        resultNode.data = value%10;
        int newCarry = value>=10?1:0;

        if (node1!=null || node2 !=null || carry>0){
            resultNode.next = addListsRecursive(
                    node1 ==null ?null :node1.next,
                    node2 ==null ? null: node2.next,
                    newCarry
            );
        }

        return resultNode;
    }


}

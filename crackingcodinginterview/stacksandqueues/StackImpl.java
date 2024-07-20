package crackingcodinginterview.stacksandqueues;

public class StackImpl {

    Node top;

    void push(Object item){
        Node newItem = new Node(item);

        newItem.next = top;
        top = newItem;
    }

//    Node pop(){
//        if (top!=null){
//
//        }
//    }
}

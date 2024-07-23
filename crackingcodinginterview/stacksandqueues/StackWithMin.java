package crackingcodinginterview.stacksandqueues;

public class StackWithMin {

    /*
    How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
    Push, pop and min should all operate in O(1) time.
     */


    NodeWithMin top;

    void push(int item){

        int newMin = Math.min(min(), item);
        NodeWithMin newItem = new NodeWithMin(newMin, item);

        newItem.next = top;
        top = newItem;
    }


    NodeWithMin pop(){
        if (top!=null){
            NodeWithMin item = top;
            top = top.next;
            return item;
        }

        return null;
    }

    NodeWithMin peek(){
        if (top!=null){
            return top;
        }

        return null;
    }

    int min(){
        if (top!=null){
            return peek().min;
        }else{
            return Integer.MAX_VALUE;
        }
    }
}

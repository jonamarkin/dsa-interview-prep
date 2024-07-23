package crackingcodinginterview.stacksandqueues;

public class QueueImpl {
    Node first, last;

    void enqueue(Object item){
        if(first==null){
            last  = new Node(item);
            first = last;
        }else{
            last.next = new Node(item);
            last = last.next;
        }
    }


    Node dequeue(Object item){
        if (first!=null){
            Node deq = first;

            first = first.next;

            return deq;

        }

        return null;
    }
}

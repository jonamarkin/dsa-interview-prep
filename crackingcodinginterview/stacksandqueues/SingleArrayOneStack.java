package crackingcodinginterview.stacksandqueues;

public class SingleArrayOneStack {

    /*
    Implement a stack using an array
     */

    int[] stackArray;
    int maxSize;
    int top;

    public SingleArrayOneStack(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("Stack is full");
            return;
        }
        stackArray[++top] = value;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }


    public static void main(String[] args) {
        SingleArrayOneStack stack = new SingleArrayOneStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Top element is: " + stack.peek()); // Should print 50
        System.out.println("Popped element is: " + stack.pop()); // Should print 50
        System.out.println("Top element after pop is: " + stack.peek()); // Should print 40

        stack.push(60); // Should print "Stack is full. Cannot push value."
    }
}

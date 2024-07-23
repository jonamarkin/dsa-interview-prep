package crackingcodinginterview.stacksandqueues;

public class SingleArrayOneStack {

    /*
    Implement a stack using an array
     */

    int[] stackArray;
    int maxSize;
    int top;

    public SingleArrayOneStack(int size){
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
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

}

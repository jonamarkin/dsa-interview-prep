package crackingcodinginterview.stacksandqueues;

public class SingleArrayTwoStacks {

    int[] stackArray;
    int maxSize;
    int top1;
    int top2;

    public SingleArrayTwoStacks(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top2 = maxSize;
        top1 = -1;
    }

    public boolean isFull(){
        return top1 + 1 == top2;
    }

    public boolean isEmpty1(){
        return top1 == -1;
    }

    public boolean isEmpty2(){
        return top2 == maxSize;
    }

    public void push1(int item){
        if (isFull()){
            System.out.println("Stack is full");
        }

        stackArray[++top1] = item;
    }

    public void push2(int item){
        if (isFull()){
            System.out.println("Stack is full");
        }

        stackArray[--top2] = item;
    }

    public int pop1(){
        if (isEmpty1()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top1--];
    }

    public int pop2(){
        if (isEmpty2()){
            System.out.println("Stack is empty");
            return -1;
        }

        return stackArray[top2++];
    }

    public int peek1(){
        if (isEmpty1()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top1];
    }

    public int peek2(){
        if (isEmpty2()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top2];
    }
}

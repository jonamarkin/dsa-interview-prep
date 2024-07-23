package crackingcodinginterview.stacksandqueues;

public class SingleArrayThreeStacks {

    /*
    Divide array into three equal parts
     */


    int stackSize;
    int[] stackArray;

    int[] stackPointer;

    public SingleArrayThreeStacks(int size){
        stackSize = size;
        stackArray = new int[stackSize * 3];
        stackPointer = new int[]{-1,-1,-1};
    }


    public boolean isEmpty(int stackNum){
        return stackPointer[stackNum]== -1;
    }

    void push(int stackNum, int value){

        //Check for overflow
        if(stackPointer[stackNum] +1 > stackSize){
            System.out.println("Stack overflow");
        }

        stackPointer[stackNum]++;
        //Calculate the corresponding index in the stack array
        int index = stackNum * stackSize + stackPointer[stackNum];

        stackArray[index] = value;
    }

    int pop(int stackNum){
        if (isEmpty(stackNum)){
            System.out.println("Stack is empty");
            return -1;
        }

        int index = stackNum * stackSize + stackPointer[stackNum];

        int item = stackArray[index];

        stackPointer[stackNum]--;

        return item;
    }

    int peek(int stackNum){
        if (isEmpty(stackNum)){
            System.out.println("Stack is empty");
            return -1;
        }

        int index = stackNum * stackSize + stackPointer[stackNum];

        return stackArray[index];
    }


    public static void main(String[] args) {

        SingleArrayThreeStacks singleArrayThreeStacks = new SingleArrayThreeStacks(300);

        singleArrayThreeStacks.push(0,1);
        singleArrayThreeStacks.push(1, 2);
        singleArrayThreeStacks.push(2, 3);

        System.out.println(singleArrayThreeStacks.peek(0));
        System.out.println(singleArrayThreeStacks.peek(1));
        System.out.println(singleArrayThreeStacks.peek(2));
    }


}

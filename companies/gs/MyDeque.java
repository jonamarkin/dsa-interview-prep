package companies.gs;

public class MyDeque {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public MyDeque(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    
    public boolean insertFront(int val){
        if(isFull()){
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        data[front] = val;
        size++;
        return true;
    }
    
    public boolean insertRear(int val){
        if(isFull()){
            return false;
        }
        rear = (rear + 1) % capacity;
        data[rear] = val;
        size++;
        return true;
    }
    
    public boolean deleteFront(){
        if (isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getFront(){
        if(isEmpty()){
            return -1;
        }
        return data[front];
    }

    public int getRear(){
        if(isEmpty()){
            return -1;
        }
        return data[rear];
    }
}

package ds_implementations;

public class PowerOfTwoMaxHeap {

    private int[] heap;
    private int size;
    private int numChildren; // Number of children for each parent

    public PowerOfTwoMaxHeap(int capacity, int numChildren) {
        heap = new int[capacity];
        size = 0;
        this.numChildren = numChildren;
    }

    public int getMax() {
        if (size == 0) {
            throw new IllegalStateException("The heap is empty");
        }
        return heap[0];
    }

    public void insert(int element) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap size overflow");
        }
        heap[size++] = element;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("The heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[--size];
        heapifyDown(0);
        return max;
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] < heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int child;
        while (numChildren * index + 1 < size) {
            child = maxChild(index);
            if (heap[index] < heap[child]) {
                swap(index, child);
            } else {
                break;
            }
            index = child;
        }
    }

    private int maxChild(int index) {
        int maxChild = numChildren * index + 1;
        int end = Math.min(size - 1, maxChild + numChildren - 1);
        for (int i = maxChild + 1; i <= end; i++) {
            if (heap[i] > heap[maxChild]) {
                maxChild = i;
            }
        }
        return maxChild;
    }

    private int parent(int index) {
        return (index - 1) / numChildren;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {

        PowerOfTwoMaxHeap powerOfTwoMaxHeap = new PowerOfTwoMaxHeap(10, 2);
        powerOfTwoMaxHeap.insert(10);
        powerOfTwoMaxHeap.insert(20);
        powerOfTwoMaxHeap.insert(15);
        powerOfTwoMaxHeap.insert(30);
        powerOfTwoMaxHeap.insert(25);

        System.out.println(powerOfTwoMaxHeap.extractMax());
    }
}

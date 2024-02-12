package ds_implementations;

public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Return the maximum element in the heap
    public int getMax() {
        if (size == 0) {
            throw new IllegalStateException("The heap is empty");
        }

        return heap[0];
    }

    // Insert a new element into the heap
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
        while (index > 0 && (heap[parent(index)] < heap[index])) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        while (leftChild(index) < size) {
            int largest = index;
            if (leftChild(index) < size && heap[leftChild(index)] > heap[largest]) {
                largest = leftChild(index);
            }

            if (rightChild(index) < size && heap[rightChild(index)] > heap[largest]) {
                largest = rightChild(index);
            }

            if (largest == index) {
                break;
            }
            swap(index, largest);
            index = largest;
        }
    }

    // Helper methods for finding parent and children indices
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Swaps two elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        // Test the heap
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(25);
        // maxHeap.insert(40);

        System.out.println(maxHeap.extractMax());

    }

}
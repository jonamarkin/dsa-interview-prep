package ds_implementations;

public class MaxHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    // The heap will be represented as an array
    // The root will be at index 1
    // We set the first element to be the largest possible integer since we are
    // making a max heap

    public MaxHeap(int size) {
        this.maxSize = size;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    // We can get a parent node by dividing the index by 2 since we are working with
    // a binary heap structure and it is represented by an array also
    private int parentNode(int position) {
        return position / 2;
    }

    // We can also get the left and right child of a parentNode by performing the ff
    // operations
    // Left child = 2*i
    // Right child = (2*i) + 1
    // If our root index was 0, our left and right chilren would haave been (2*i)+1
    // and (2*i)+2 respectively

    private int leftChild(int parentNode) {
        return 2 * parentNode;
    }

    private int rightChild(int parentNode) {
        return (2 * parentNode) + 1;
    }
}
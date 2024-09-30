package leetcode.blind75.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    /*
    Given an integer array nums and an integer k, return the kth largest element in the array.

    Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Can you solve it without sorting?
     */
    public int findKthLargest(int[] nums, int k) {
        //Create a min-heap or priority queue to store the top-k elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //Iterate
        for (int num : nums){
            minHeap.offer(num);

            //If miheap size exceeds k, remove the smallest element
            if (minHeap.size()>k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}

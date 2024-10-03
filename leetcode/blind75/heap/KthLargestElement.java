package leetcode.blind75.heap;

import java.util.Arrays;
import java.util.Collections;
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

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};

        System.out.println(findKthLargest2(arr, 4));
    }

    public static int findKthLargest2(int[] nums, int k) {
        // your solution here
        Arrays.sort(nums);
        //Collections.reverse(Arrays.asList(nums));

        int result = nums[nums.length-k];

        return result;

    }
}

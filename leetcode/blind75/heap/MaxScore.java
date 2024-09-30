package leetcode.blind75.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxScore {

    /*
    You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

    For chosen indices i0, i1, ..., ik - 1, your score is defined as:

    The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
    It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
    Return the maximum possible score.

    A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

     */

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        //Create list of pairs
        List<int[]> pairs = new ArrayList<>();
        for (int i=0; i<n; i++){
            pairs.add(new int[]{nums1[i], nums2[i]});
        }

        //Sort the pairs by nums2 values in descending order
        pairs.sort((a, b)->b[1]-a[1]);

        //Mim heap to maintain the top k largest nums1 values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long sumOfTopKNums1 = 0;
        long maxScore = 0;

        //Iterate over the pairs
        for (int[] pair : pairs){
            int num1 = pair[0];
            int num2 = pair[1];

            //Add current nums1 value to heap and update the sum
            minHeap.offer(num1);
            sumOfTopKNums1 += num1;

            //If heap size exceeds k, remove smallest element from heap
            if (minHeap.size() > k){
                sumOfTopKNums1 -=minHeap.poll();
            }

            //if we have exactly k  elements in the heap calculate the scire
            if (minHeap.size()==k){
                long score = sumOfTopKNums1 * num2;
                maxScore = Math.max(score, maxScore);
            }
        }

        return maxScore;
    }
}

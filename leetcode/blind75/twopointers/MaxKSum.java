package leetcode.blind75.twopointers;

import java.util.Arrays;
import java.util.HashMap;

public class MaxKSum {

    /*
    You are given an integer array nums and an integer k.

    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

    Return the maximum number of operations you can perform on the array.
     */

    public static int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int numOperations = 0;
        int n = nums.length;

        int leftPointer = 0;
        int rightPointer = n-1;

        while (leftPointer < rightPointer){
            int sum = nums[leftPointer] + nums[rightPointer];

            if (sum == k){
                numOperations ++;
                leftPointer++;
                rightPointer--;
            } else if (sum < k) {
                leftPointer++;
            }else{
                rightPointer--;
            }

        }

        return numOperations;
    }


    public static int maxOperationsMap(int[] nums, int k) {
        int numOperations = 0;
        HashMap<Integer, Integer> map= new HashMap<>();

        for (int num:nums){
            int complement = k-num;

            if (map.getOrDefault(complement, 0) >0){
                numOperations++;
                map.put(complement, map.get(complement)-1);
            }else{
                map.put(num, map.getOrDefault(num, 0) +1);
            }
        }

        return numOperations;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k =5;

        System.out.println(maxOperationsMap(arr, 5));
    }
}

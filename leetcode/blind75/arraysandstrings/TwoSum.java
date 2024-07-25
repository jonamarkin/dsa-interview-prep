package leetcode.blind75.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
     */

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int complementary = target - nums[i];
            if (hashMap.containsKey(complementary)){
                return new int[]{i, hashMap.get(complementary)};
            }else{
                hashMap.put(nums[i], i);
            }
        }

        return null;
    }
}

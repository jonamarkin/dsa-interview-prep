package leetcode.blind75.arraysandstrings;

public class IncreasingTriplet {

    /*
    Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
    If no such indices exists, return false.
     */
    public boolean increasingTriplet(int[] nums) {

        int len = nums.length;

        if (len <3){
            return  false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums){
            if (num <= first){
                first = num;
            } else if (num <= second) {
                second = num;
            }else{
                return  true;
            }
        }

        return false;

    }
}

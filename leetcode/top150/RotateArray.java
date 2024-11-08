package leetcode.top150;

public class RotateArray {

    /*
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     */

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];

        for (int i=0; i<n; i++){
            temp[(i+k)%n] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }



}

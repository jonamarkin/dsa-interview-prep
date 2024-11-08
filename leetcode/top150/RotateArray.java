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


    public void rotate2(int[] nums, int k) {
        int n = nums.length;

        k = k%n;

        reverseArr(nums, 0, n-1);

        reverseArr(nums, 0, k-1);

        reverseArr(nums, k, n-1);
    }

    private void reverseArr(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }


}

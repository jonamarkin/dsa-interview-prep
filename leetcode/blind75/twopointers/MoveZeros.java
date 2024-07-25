package leetcode.blind75.twopointers;

import java.util.Arrays;

public class MoveZeros {

    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]


    Example 2:

    Input: nums = [0]
    Output: [0]
     */

    public static void main(String[] args) {
        int[] nums = {0,0};

        moveZeroesCorrect(nums);
    }


    /*Wrong solution*/
    public static void moveZeroes(int[] nums) {



        int leftPointer = 0;
        int rightPointer = 1;

        while (leftPointer < rightPointer && rightPointer<nums.length){

            while(nums[leftPointer]!=0){
                leftPointer++;
            }

            while(nums[rightPointer]==0){
                rightPointer++;
            }
            if(nums[leftPointer]==0 && nums[rightPointer]!=0){
                //Swap them
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = temp;

                leftPointer++;
                rightPointer++;
            }

        }

        System.out.println(Arrays.toString(nums));
    }


    /*Correct solution*/
    public static void moveZeroesCorrect(int[] nums) {

        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer<nums.length; rightPointer++){
            if (nums[rightPointer]!=0){
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = temp;

                leftPointer++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}

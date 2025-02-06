package leetcode.top150.arraysandstrings;

public class RemoveElement {

    /*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

    Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
    Return k.
     */

    public static int removeElement(int[] nums, int val) {

        int n  = nums.length;

        int k = 0;

        int indexToInsert = 0;
        for(int i=0; i<n; i++){
            if (nums[i]!=val){
                nums[indexToInsert++] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,5,3,1,2,2,7,9,2,3};

        System.out.println(removeElement(nums, 2));
    }
}

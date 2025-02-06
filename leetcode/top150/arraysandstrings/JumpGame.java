package leetcode.top150.arraysandstrings;

public class JumpGame {

    /*
    You are given an integer array nums. You are initially positioned at the array's first index,
    and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.
     */


    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {

        return backtrack(nums, 0);
    }

    private static boolean backtrack(int[] nums, int index) {
        //Base case - that is if we hve reached the last index ot beyond
        if (index >= nums.length-1){
            return true;
        }

        //Otherwise we explore the possible number of jumps available from the current index
        for (int jump=1; jump<=nums[index]; jump++){
            if (backtrack(nums, jump+index)){
                return true;
            }
        }

        return false;
    }


}

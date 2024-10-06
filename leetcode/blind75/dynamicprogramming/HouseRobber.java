package leetcode.blind75.dynamicprogramming;

public class HouseRobber {

    public int rob(int[] nums) {

        //Handle edge cases

        if (nums ==null || nums.length ==0){
            return 0;
        }

        if (nums.length ==1){
            return nums[0];
        }

        //Crate dp array to store the max money that can be robbed up to each house
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //Fill up the dp array
        for (int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        //Max that can be robbed is stored in n-1
        return dp[n-1];
    }
}

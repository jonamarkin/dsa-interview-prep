package leetcode.blind75.dynamicprogramming;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        // Step 1: Calculate the total sum of elements in nums
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Check if the target can be achieved based on total sum
        // The sum P must be a non-negative integer
        if ((target + totalSum) % 2 != 0 || Math.abs(target) > totalSum) {
            return 0;
        }

        // Step 3: Determine the sum P we need to find as a subset
        int subsetSum = (target + totalSum) / 2;

        // Step 4: Create a dp array to count subsets that sum up to subsetSum
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // There is one way to reach 0 sum, by not choosing any element

        // Step 5: Fill the dp array
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        // Step 6: The result is the number of ways to achieve subsetSum
        return dp[subsetSum];
    }
}

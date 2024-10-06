package leetcode.blind75.dynamicprogramming;

public class Knapsack {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        //Create DP table
        int[][] dp = new int[n+1][capacity+1];

        //Build the dp
        for (int i=0; i<=n; i++){
            for (int w =0; w<=capacity; w++){

                //Base case : If there are no items in the knapsack or knapsack is empty
                if (i==0 || w ==0){
                    dp[i][w] = 0;
                }
                //If the weight of the current item is less than or equal to the capacity
                else if (weights[i-1]<=w) {
                    //Take the maximum including the item or excluding it
                    // 1. Include item: add its value and reduce capacity
                    // 2. Exclude the item: Take the value from previous item
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w]);
                }else{
                    // If the weight of the current item exceeds the capacity don't include it
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        return dp[n][capacity];
    }
}

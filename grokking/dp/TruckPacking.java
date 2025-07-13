package grokking.dp;

import java.util.Arrays;

public class TruckPacking {

    //Recursive solution
    public static int packRecursive(int[] weights, int i, int capacity) {
        if(i<0 || capacity == 0){
            return 0;
        }

        //If the current item does not fit do not take it
        if(weights[i] > capacity){
            return packRecursive(weights, i-1, capacity);
        }else{
            return Math.max(weights[i] + packRecursive(weights, i-1, capacity-weights[i]),
                    packRecursive(weights, i-1, capacity));
        }
    }


    //Memoized solution
    public static int packMemoized(int[] weights, int i, int capacity, int[][] memo) {
        if (i<0 || capacity == 0){
            return 0;
        }

        if (memo[i][capacity] != -1){
            return memo[i][capacity];
        }

        if(weights[i] > capacity){
            memo[i][capacity] = packMemoized(weights, i-1, capacity, memo);
        }else{
            memo[i][capacity] = Math.max(weights[i] + packMemoized(weights, i-1, capacity-weights[i], memo),
                    packMemoized(weights, i-1, capacity, memo));
        }

        return memo[i][capacity];
    }

    //DP solution
    public static int packDP(int[] weights, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n+1][capacity + 1];


        for(int i=1; i<=n; i++){
            for(int w = 0; w <= capacity; w++){
                if(weights[i-1] <= w){
                    dp[i][w] = Math.max(weights[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w]);
                }else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        return dp[n][capacity];
    }


    public static void main(String[] args) {
        int[] weights = { 2, 3, 4, 5};
        int capacity = 10;

        int n = weights.length;
        int[][] memo = new int[n][capacity + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        int result = packMemoized(weights, n - 1, capacity, memo);

        System.out.println("Result: " + result);

        int[] weights2 = { 2, 3, 4, 5};
        int capacity2 = 10;
        int result2 = packDP(weights2, capacity2);
        System.out.println("Result: " + result2);
    }
}

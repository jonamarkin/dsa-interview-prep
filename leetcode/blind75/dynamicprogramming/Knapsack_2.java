package leetcode.blind75.dynamicprogramming;

public class Knapsack_2 {

    // Recursion Approach
    // This method returns the maximum value that can be obtained by putting items in a knapsack of capacity W.
    // It explores all possible subsets of items, making it less efficient for large inputs due to overlapping subproblems.
    public static int knapSackRecursion(int W, int[] wt, int[] val, int n) {
        // Base case: If there are no items left or knapsack capacity is 0, the value is 0.
        if (n == 0 || W == 0) {
            return 0;
        }

        // If the weight of the current item is more than the knapsack capacity, we cannot include it.
        if (wt[n - 1] > W) {
            return knapSackRecursion(W, wt, val, n - 1);
        } else {
            // Return the maximum of including or excluding the current item:
            // 1. Include the item: add its value and subtract its weight from W, then solve the subproblem.
            // 2. Exclude the item: solve the subproblem without considering the current item.
            return Math.max(
                    val[n - 1] + knapSackRecursion(W - wt[n - 1], wt, val, n - 1),
                    knapSackRecursion(W, wt, val, n - 1)
            );
        }
    }

    // Memoization Approach
    // This method uses a 2D dp array to store the results of subproblems and avoid re-computation.
    public static int knapSackMemo(int W, int[] wt, int[] val, int n, int[][] dp) {
        // Base case: If there are no items left or knapsack capacity is 0, the value is 0.
        if (n == 0 || W == 0) {
            return 0;
        }

        // If the result is already computed for this subproblem, return it.
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // If the weight of the current item is more than the knapsack capacity, we cannot include it.
        if (wt[n - 1] > W) {
            dp[n][W] = knapSackMemo(W, wt, val, n - 1, dp);
            return dp[n][W];
        } else {
            // Calculate and store the maximum value obtained by including or excluding the current item.
            dp[n][W] = Math.max(
                    val[n - 1] + knapSackMemo(W - wt[n - 1], wt, val, n - 1, dp),
                    knapSackMemo(W, wt, val, n - 1, dp)
            );
            return dp[n][W];
        }
    }

    // Wrapper function to initialize dp array and call the memoization solution.
    public static int knapSackMemoWrapper(int W, int[] wt, int[] val, int N) {
        // Initialize a 2D array dp with all values set to -1 to indicate uncomputed subproblems.
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }
        // Call the memoization-based function to solve the problem.
        return knapSackMemo(W, wt, val, N, dp);
    }

    // Tabular Method (Dynamic Programming)
    // This approach uses a 2D table to store results of all subproblems iteratively.
    public static int knapSackTabular(int W, int[] wt, int[] val, int n) {
        // Create a 2D table K where K[i][w] represents the maximum value for a knapsack with capacity w using the first i items.
        int[][] K = new int[n + 1][W + 1];

        // Build the table K in a bottom-up manner
        for (int i = 0; i <= n; i++) {  // Iterate through all items
            for (int w = 0; w <= W; w++) {  // Iterate through all capacities
                // Base case: If there are no items or knapsack capacity is 0, the value is 0.
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                }
                // If the weight of the current item is less than or equal to the capacity w
                else if (wt[i - 1] <= w) {
                    // Take the maximum of including the item or excluding it:
                    // 1. Include the item: add its value and reduce the capacity.
                    // 2. Exclude the item: take the value from the previous item.
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    // If the weight of the current item exceeds the capacity, don't include it.
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        // The final value in the table represents the maximum value for the given knapsack capacity and items.
        return K[n][W];
    }

    // Main function to test all three approaches
    public static void main(String[] args) {
        // Sample input: item weights and values, and knapsack capacity
        int[] wt = {1, 2, 3, 8, 7, 4};
        int[] val = {20, 5, 10, 40, 15, 25};
        int W = 10;
        int N = val.length;

        // Testing all three approaches
        System.out.println("Recursion approach: " + knapSackRecursion(W, wt, val, N));
        System.out.println("Memoization approach: " + knapSackMemoWrapper(W, wt, val, N));
        System.out.println("Tabular approach: " + knapSackTabular(W, wt, val, N));
    }
}

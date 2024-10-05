package faang.amazon;

public class MinCostClimbing {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        return Math.min(minCost(n-1, cost), minCost(n-2, cost));
    }

    private int minCost(int i, int[] cost){
        if (i<0) return 0;
        if (i==0 || i==1) return cost[i];

        return cost[i] + Math.min(minCost(i-1, cost), minCost(i-2, cost));
    }


    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i=2; i<n; i++){
            dp[i] = Math.min(cost[n-1] + dp[n-1], cost[n-2] + dp[n-2]);
        }

        return dp[n];
    }
}

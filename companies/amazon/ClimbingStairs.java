package companies.amazon;

public class ClimbingStairs {

    /*
    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    public int climbStairs(int n) {

        int one = 1;
        int two = 1;

        for (int i =0; i<n-1; i++){
            int temp = one;
            one = one +two;
            two = temp;
        }

        return one;
    }

    //Non-optimal solution with recursion

    public int climbStairs2(int n) {
        if (n==0){
            return 1;
        }
        if (n<0){
            return 0;
        }

        return climbStairs2(n-1) + climbStairs2(n-2);
    }


    public int climbStairs3(int n) {
        if (n<=1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] =1;

        for (int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

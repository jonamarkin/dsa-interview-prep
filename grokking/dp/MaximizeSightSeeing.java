package grokking.dp;

import java.util.Arrays;

public class MaximizeSightSeeing {

    public static int maximizeSightSeeingRecursive(int[] times, int[] points, int totalDays, int i){
        if(totalDays ==0 || i<0){
            return 0;
        }

        if (times[i] > totalDays){
            return maximizeSightSeeingRecursive(times, points, totalDays, i-1);
        }else{
            return Math.max(
                    maximizeSightSeeingRecursive(times, points, totalDays, i-1),
                    points[i] + maximizeSightSeeingRecursive(times, points, totalDays - times[i], i-1)
            );
        }

    }

    public static int maximizeSightSeeingMemo(int[] times, int[] points, int totalDays, int i, int [][]memo){
        if(totalDays==0 || i<0){
            return 0;
        }

        if(memo[i][totalDays]!=-1){
            return memo[i][totalDays];
        }

        if (times[i] > totalDays){
            return maximizeSightSeeingMemo(times, points, totalDays, i-1, memo);
        }else{
            return Math.max(
                    maximizeSightSeeingMemo(times, points, totalDays, i-1, memo),
                    points[i] + maximizeSightSeeingMemo(times, points, totalDays - times[i], i-1, memo)
            );
        }


    }

    public static int maximizeSightSeeingDP(int[] times, int[] points, int totalDays){
        int n = times.length;
        int [][] dp = new int[n+1][totalDays+1];

        for(int i=1; i<=n; i++){
            for(int d = 0; d<=totalDays; d++ ){
                if(times[i-1]<=d){
                    dp[i][d] = Math.max(
                            dp[i-1][d],
                            points[i-1] + dp[i-1][d-times[i-1]]
                    );
                }else{
                    dp[i][d] = dp[i-1][d];
                }
            }
        }

        return dp[n][totalDays];
    }

    public static void main(String[] args) {
        int[] time = {2, 3, 4};
        int[] points = {40, 50, 65};
        int totalDays = 7;

        int[][] memo = new int[time.length][totalDays+1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }

        System.out.println(maximizeSightSeeingRecursive(time, points, totalDays, time.length-1));
        System.out.println(maximizeSightSeeingMemo(time, points, totalDays, time.length-1, memo));
        System.out.println(maximizeSightSeeingDP(time, points, totalDays));
    }

}

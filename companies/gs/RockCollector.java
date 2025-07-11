package companies.gs;

public class RockCollector {
    public static int optimalPath(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
         }

        int rows = grid.length;
        int cols = grid[0].length;

        //dp[i][j] will store the maximum rocks to reach grid[i][j]
        int[][] dp = new int[rows][cols];

        for (int r = rows-1; r>=0; r--){
            for (int c = 0; c<cols; c++){
                int fromBelow = r<rows-1 ? dp[r+1][c] : 0;
                int fromRight = c>0 ? dp[r][c-1] : 0;
                dp[r][c] = grid[r][c] + Math.max(fromBelow, fromRight);
            }
        }


        return dp[0][cols -1];


    }

    // Basic test cases
    public static boolean doTestsPass() {
        return optimalPath(new int[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        }) == 10;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass!");
        } else {
            System.out.println("Tests failed!");
        }
    }
}

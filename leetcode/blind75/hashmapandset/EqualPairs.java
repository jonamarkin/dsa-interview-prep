package leetcode.blind75.hashmapandset;

public class EqualPairs {

    /*
    Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

    A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
     */

    public int equalPairs(int[][] grid) {

        int count = 0;
        int len = grid.length;

        for (int i=0; i<len; i++){
            for (int j = 0; j<len; j++){
                boolean isEqual = true;
                for (int k=0; k<len; k++){
                    if (grid[i][k]!=grid[k][j]){
                        isEqual =false;
                        break;
                    }
                }

                if (isEqual){
                    count++;
                }
            }
        }

        return count;
    }
}

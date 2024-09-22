package leetcode.blind75.hashmapandset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public int equalPairs2(int[][] grid) {
        int count = 0;
        int len = grid.length;

        //Create a hashmap of the various rows in the matrix and compare it to the columns
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        for (int i=0; i<len; i++){
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<len; j++){
                row.add(grid[i][j]);
            }

            rowMap.put(row, rowMap.getOrDefault(row, 0)+1);
        }

        for (int j=0; j<len; j++){
            List<Integer> col = new ArrayList<>();
            for (int i=0; i<len; i++){
                col.add(grid[i][j]);
            }

            //for every column compare check if it exists in thr row map
            count+=rowMap.getOrDefault(col, 0);
        }


        return count;
    }
}

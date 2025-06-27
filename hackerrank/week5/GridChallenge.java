package hackerrank.week5;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {

    public static String gridChallenge(List<String> grid) {
        // Write your code here

        int n = grid.size();
        char[][] sortedGrid = new char[n][];

        for(int i=0; i<n; i++){
            char[] chars = grid.get(i).toCharArray();
            Arrays.sort(chars);
            sortedGrid[i] = chars;
        }

        for(int col = 0; col< sortedGrid[0].length; col++){
            for(int row = 0; row<n-1; row++){
                if(sortedGrid[row][col] > sortedGrid[row+1][col]){
                    return "NO";
                }
            }
        }

        return "YES";

    }

}

package hackerrank.week4;

import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(minimumAbsoluteDifference(List.of(-2,2,4)));
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        int minAbsolute = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                int currMinAbsolute = Math.abs(arr.get(i)-arr.get(j));
                if ( currMinAbsolute <minAbsolute) {
                    minAbsolute = currMinAbsolute;
                }
            }
        }

        return minAbsolute;
    }
}

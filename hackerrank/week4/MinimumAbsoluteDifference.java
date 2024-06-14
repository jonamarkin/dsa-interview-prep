package hackerrank.week4;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(minimumAbsoluteDifference(List.of(-2,2,4)));
        System.out.println(minimumAbsoluteDifferenceOpt(Stream.of(-2,2,4).collect(Collectors.toList())));
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


    public static int minimumAbsoluteDifferenceOpt(List<Integer> arr) {
        // Write your code here
        int minAbsolute = Integer.MAX_VALUE;

        Collections.sort(arr);

        for (int i = 1; i < arr.size(); i++) {
            int minAbs = Math.abs(arr.get(i) - arr.get(i-1));
            if (minAbs < minAbsolute){
                minAbsolute = minAbs;
            }
        }

        return minAbsolute;
    }
}

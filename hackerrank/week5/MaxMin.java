package hackerrank.week5;

import java.util.Collections;
import java.util.List;

public class MaxMin {

    /*

     */

    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here

        int minUnfairness = Integer.MAX_VALUE;

        for (int i=0; i<arr.size() - k; i++){
            List<Integer> subArray = arr.subList(i, i+k);
            int unfairness = Collections.max(subArray) - Collections.min(subArray);
            minUnfairness = Math.min(unfairness, minUnfairness);
        }

        return minUnfairness;
    }
}

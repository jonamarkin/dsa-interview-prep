package hackerrank.week1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class findMedian {
    public static void main(String[] args) {

        // List<Integer> arr = Stream.of(4, 3, 2, 1, 8).collect(Collectors.toList());
        List<Integer> arr = Arrays.asList(4, 3, 2, 1, 8);

        System.out.println(findMedian(arr));
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        System.out.println(arr);

        // Since indexing starts from 0, the floored division of the list size by 2
        // resolves to the middle element
        int medianPosition = Math.floorDiv(arr.size(), 2);

        return arr.get(medianPosition);
    }
}

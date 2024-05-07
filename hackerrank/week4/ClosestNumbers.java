package hackerrank.week4;

import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosestNumbers {

    public static void main(String[] args) {

        List<Integer> arr = Stream.of(3,4,2,1,5).collect(Collectors.toList());
        System.out.println(closestNumbers(arr));
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> resultArr = new ArrayList<>();

        Collections.sort(arr);

        int absoluteDifference = Integer.MAX_VALUE;
        for(int i = 0; i<arr.size() -1; i++){
            absoluteDifference = Math.min(Math.abs(arr.get(i) - arr.get(i+1)), absoluteDifference);
        }

        //Loop through the array again to determine the pairs
        for(int i = 0; i<arr.size() -1; i++){
            if(Math.abs(arr.get(i) - arr.get(i+1)) == absoluteDifference){
                resultArr.add(arr.get(i));
                resultArr.add(arr.get(i+1));
            }
        }

        return resultArr;
    }
}

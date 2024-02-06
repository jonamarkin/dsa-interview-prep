package hackerrank.week1;

import java.util.Collections;
import java.util.List;


/* 
 * Problem Description:
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. 
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 */

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    long maxValues = 0;
    long minValues = 0;
    
    //Sort the list
    Collections.sort(arr);
    
    //Sum from index 1 to the last index since the list contains 5 integers and we want the biggest 4 to give us the maximum 
    for(int i=1; i<arr.size(); i++){
        maxValues+=arr.get(i);
    }
    
    //sum from index 0 to second-to-last index to get the min sum since that will range wil contain the min elements in the list
    for(int i=0; i<arr.size()-1; i++){
        minValues+=arr.get(i);
    }
    
    System.out.println(minValues + " " + maxValues);

    }

    /*
 * Another solution will be to loop through the array once and in that loop calculate the totalSum, find the min and max elements
 * as well. Then outside the loop subtract the min and max values from the totalSum to get the minSum and maxSum respectively.
 * This way you don't need to sort the array.
 */

    public static void miniMaxSum2(List<Integer> arr) {
    // Write your code here
    long totalSum = 0, minElement = Long.MAX_VALUE, maxElement = Long.MIN_VALUE;

        // Calculate total sum and find min and max elements
        for (long num : arr) {
            totalSum += num;
            if (num < minElement) {
                minElement = num;
            }
            if (num > maxElement) {
                maxElement = num;
            }
        }

        long minSum = totalSum - maxElement;
        long maxSum = totalSum - minElement;

        // Printing the minimum and maximum sums
        System.out.println(minSum + " " + maxSum);

    }

}



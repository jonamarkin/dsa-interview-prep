package hackerrank.week4;

import com.sun.source.doctree.SeeTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PickingNumbers {
    /*
    Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal to 1
     */

    public static void main(String[] args) {
        List<Integer> a = Stream.of(1, 1, 2, 2, 4, 4, 5, 5, 5).collect(Collectors.toList());
        System.out.println(pickingNumbersBruteForce(a));
        System.out.println(pickingNumbersOptimized(a));


    }

    public static int pickingNumbersBruteForce(List<Integer> a) {
        // Write your code here
        int maxLength = 0;

        Collections.sort(a); //Had to sort cos it did not care about it being contiguous

        for (int i = 0; i < a.size(); i++) {
            int min = a.get(i);
            int max = a.get(i);


            for (int j = i; j < a.size(); j++) {
                min = Math.min(min, a.get(j));
                max = Math.max(max, a.get(j));


                if (max - min <= 1) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;

    }


    public static int pickingNumbersOptimized(List<Integer> a) {
        //Sort List and Scan over it
        Collections.sort(a);

        int count = 1;
        int maxLength = 0;

        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) - a.get(i - 1) <= 1) {
                count++;
            } else {
                maxLength = Math.max(maxLength, count);
                count = 1;
            }
        }

        maxLength = Math.max(maxLength, count);
        return maxLength;

    }


    //Using a Deque
    public static int pickingNumbersDeque(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        Deque<Integer> deque = new LinkedList<>();
        int maxLength = 0;

        for (int num : a) {
            while (!deque.isEmpty() && Math.abs(num - deque.peekFirst()) > 1) {
                //Remove elements from the front of the deque until the condition is satisfied
                deque.pollFirst();
            }
            //Add the current element to the end of the queue
            deque.offerLast(num);

            maxLength = Math.max(maxLength, deque.size());
        }

        return maxLength;
    }


}

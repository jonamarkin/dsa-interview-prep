package random;

import java.util.HashSet;
import java.util.Set;

public class DifferenceCheckerAll {
    /*
    Ensure that every pair of distinct elements in the given array has an absolute difference of exactly k
     */

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 12};
        int k = 3;

        System.out.println(checkAllDifferences(arr, k));
    }

    public static boolean checkAllDifferences(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        Set<Integer> integerSet = new HashSet<>();

        //Populate the hashset with the elements and find the max and min in the process
        for (int num : arr) {
            integerSet.add(num);
            if (num < minValue) {
                minValue = num;
            }
            if (num > maxValue) {
                maxValue = num;
            }
        }

        //Now we check if we have the sequence of x+k, x+2k....to the max value in the hashset
        for(int i =minValue; i <maxValue; i+=k){
            if(!integerSet.contains(i)){
                return false;
            }
        }

        return true;
    }
}

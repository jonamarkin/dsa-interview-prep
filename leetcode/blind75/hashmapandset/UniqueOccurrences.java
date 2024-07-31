package leetcode.blind75.hashmapandset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurrences {

    /*
    Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
     */

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> occurrences = new HashMap<>();

        for (int num: arr){
            occurrences.put(num, occurrences.getOrDefault(num, 0)+1);
        }

        HashSet<Integer> setOccurrence = new HashSet<>();

        for (int val : occurrences.values()){
            if (setOccurrence.contains(val)){
                return false;
            }else{
                setOccurrence.add(val);
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3};

        System.out.println(uniqueOccurrences(arr));
    }
}

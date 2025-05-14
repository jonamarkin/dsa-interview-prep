package random.exponent;

import java.util.*;

public class ArrayDifference {

    /*
    Write a function diff(arrA, arrB) that accepts two arrays and returns a new array that contains all values that
    are not contained in both input arrays. The order of numbers in the result array does not matter.
     */

    public static List<Integer> diff(Integer[] arrA, Integer[] arrB) {
        // your code goes here
        Set<Integer> setA = new HashSet<>(Arrays.asList(arrA));
        Set<Integer> setB = new HashSet<>(Arrays.asList(arrB));

        List<Integer> result = new ArrayList<>();

        for(int i : setA){
            if(!setB.contains(i)){
                result.add(i);
            }
        }

        for(int i:setB){
            if(!setA.contains(i)){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // debug your code below
        Integer[] arrA = {1, 2, 3, 4};
        Integer[] arrB = {3, 4, 5, 6};
        List<Integer> diff = diff(arrA, arrB);
        System.out.println(diff); // Output: [1, 2, 5, 6] or any other order
    }
}

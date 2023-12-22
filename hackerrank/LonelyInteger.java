package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LonelyInteger {
    public static void main(String[] args) {
        List<Integer> arr = Stream.of(1, 2, 3, 4, 3, 2, 1).collect(Collectors.toList());

        System.out.println(lonelyIntegerSortSingleStep(arr));
    }

    // Solution with Hashmap
    public static int lonelyInteger(List<Integer> a) {

        int lonelyInteger = a.get(0);

        // Put the numbers and their frequencies into a hashmap
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : a) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        // Loop through the hashmap looking for an element with occurence of 1
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                lonelyInteger = entry.getKey();
            }
        }
        return lonelyInteger;
    }

    // Solution with Sorting
    public static int lonelyIntegerSort(List<Integer> a) {
        // Sort the list
        Collections.sort(a);

        System.out.println(a);

        // Loop through the array. Since it is sorted all duplicates must follow each
        // other
        // If the current value is not equal to the one after it, that is the lonely
        // integer
        for (int i = 0; i < a.size() - 1; i++) {
            if (!a.get(i).equals(a.get(i + 1))) {
                System.out.println(i);
                System.out.println(i + 1);
                return a.get(i);
            }
        }

        return a.get(a.size() - 1);
    }

    // The above solution is faulty and will not work. This is because I am not
    // checking for left and right of each number
    // index out of bounds error when we get to the last element as well
    // A better approach will be to use a step of 2 in the loop.
    // In that case if no lonely integer is encountered then the solution will be to
    // return the last digit as the lonely one

    public static int lonelyIntegerSort2(List<Integer> a) {

        Collections.sort(a);

        for (int i = 0; i < a.size() - 1; i += 2) {
            if (!a.get(i).equals(a.get(i + 1))) {
                return a.get(i);
            }
        }
        return a.get(a.size() - 1);
    }

    // Solution with single step = 1
    public static int lonelyIntegerSortSingleStep(List<Integer> a) {
        // Sort the list
        Collections.sort(a);

        // Iterate through the list
        for (int i = 0; i < a.size() - 1; i++) {
            // Check if the current element is different from both its neighbors
            if ((i == 0 || !a.get(i).equals(a.get(i - 1))) && !a.get(i).equals(a.get(i + 1))) {
                return a.get(i);
            }
        }

        // Return the last element if no lonely integer is found in the loop
        // This handles the case where the lonely integer is at the end of the list
        return a.get(a.size() - 1);
    }

}

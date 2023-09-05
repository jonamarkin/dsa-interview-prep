package hackerrank;

import java.util.List;

/*
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. 
 * Print the decimal value of each fraction on a new line with 6 places after the decimal.
 */

public class plus_minus {
    public static void plusMinus(List<Integer> arr) {
    // Initialize counters for positive, negative, and zero numbers
        int posCount = 0;
        int negCount = 0;
        int zeroCount = 0;

        // Traverse the array and update counters
        for (int num : arr) {
            if (num > 0) {
                posCount++;
            } else if (num < 0) {
                negCount++;
            } else {
                zeroCount++;
            }
        }

        // Calculate the ratios
        double totalElements = arr.size();
        double posRatio = posCount / totalElements;
        double negRatio = negCount / totalElements;
        double zeroRatio = zeroCount / totalElements;

        // Print the ratios to 6 decimal places
        System.out.printf("%.6f%n", posRatio);
        System.out.printf("%.6f%n", negRatio);
        System.out.printf("%.6f%n", zeroRatio);
    }
}

package hackerrank.week2;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        int n = 4; // Size of the square matrix
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(i + j); // Example value for each cell
            }
            matrix.add(row);
        }

        System.out.println(diagonalDifference(matrix));
    }

    /**
     * 
     * To calculate the absolute difference between the sums of the diagonals of a
     * square matrix, you need to sum the elements on the two main diagonals and
     * then compute the absolute difference between these sums.
     * The first diagonal (the primary diagonal) is from the top-left to the
     * bottom-right of the matrix, and the second diagonal (the secondary diagonal)
     * is from the top-right to the bottom-left.
     * Here is a step-by-step explanation of the algorithm:
     * Initialize two sums to zero, one for each diagonal.
     * Loop over the matrix. If the matrix is n x n:
     * For the primary diagonal, the elements have indices where the row index
     * equals the column index (i.e., [0][0], [1][1], [2][2], ..., [n-1][n-1]).
     * For the secondary diagonal, the elements have indices where the row index and
     * column index sum up to n - 1 (i.e., [0][n-1], [1][n-2], [2][n-3], ...,
     * [n-1][0]).
     * 
     * Calculate the absolute difference between the two sums.
     * 
     * @param arr
     * @return
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int primaryDiagonalSum = 0;
        int secondarydiagonalSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            primaryDiagonalSum += arr.get(i).get(i);
            secondarydiagonalSum += arr.get(i).get(arr.size() - 1 - i);
        }

        return Math.abs(secondarydiagonalSum - primaryDiagonalSum);
    }
}

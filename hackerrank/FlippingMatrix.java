package hackerrank;

import java.util.List;

public class FlippingMatrix {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3, 4),
                List.of(5, 6, 7, 8),
                List.of(9, 10, 11, 12),
                List.of(13, 14, 15, 16));

        System.out.println("Maximum sum after flipping: " + flippingMatrix(matrix));
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Find the maximum value in each 2x2 block
                int maxVal = Math.max(
                        Math.max(matrix.get(i).get(j), matrix.get(i).get(2 * n - j - 1)), // Upper quadrants
                        Math.max(matrix.get(2 * n - i - 1).get(j), matrix.get(2 * n - i - 1).get(2 * n - j - 1)) // Lower
                                                                                                                 // quadrants
                );
                // Add the maximum value to the total sum
                maxSum += maxVal;
            }
        }

        return maxSum;
    }

    /**
     * Explanation
     * Alright, let's explain this in a simpler way:
     * 
     * Imagine you have a big square made of little squares, like a giant
     * checkerboard, but each little square has a number in it. This big square is
     * special because it's perfectly symmetrical, like a butterfly's wings. So, if
     * you fold it in half down the middle or across, the two sides match up!
     * 
     * Now, let's pretend you're playing a game. The goal of the game is to make the
     * top left corner of this big square have the biggest numbers possible. But
     * here's the twist: you can only swap little squares that are directly across
     * from each other in the middle lines (either horizontally or vertically).
     * 
     * Here's how you play the game:
     * 
     * 1. **Looking at Small Squares**: You look at each little square in the top
     * left corner of the big square.
     * 
     * 2. **Find Bigger Numbers**: For each little square you're looking at, you
     * also look at three other squares: the one directly across from it on the same
     * row, the one directly across from it on the same column, and the one
     * diagonally opposite. Among these four squares, you find the biggest number.
     * 
     * 3. **Pick the Biggest**: You then put this biggest number in the little
     * square you're looking at in the top left corner. You do this for every little
     * square in the top left corner.
     * 
     * 4. **Add Them Up**: After you've put all the biggest numbers in the top left
     * corner, you add them all up. That's your score in the game!
     * 
     * This is what the code does. It's like playing this game with the big square
     * (the matrix) to get the highest score (the sum of numbers) in the top left
     * corner. The computer looks at every little square in the top left, finds the
     * biggest number it can swap into that square, and then adds up all those big
     * numbers for the final score.
     */
}

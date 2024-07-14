package crackingcodinginterview.arraysandstrings;

public class RotateMatrixBy90 {

    /*
    Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
    Can you do this in place?
     */
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] rotatedMatrix = rotateNotInPlace(matrix);

        // Print rotated matrix
        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[i].length; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    Solution with additional space:

    Create an empty matrix of the same size
    Rotating by 90 means (i,j) = (j, n-1-i)
    Loop through the 2d array and fill up the newly created empty matrix
     */

    public static int[][] rotateNotInPlace(int[][] matrix){
        int len = matrix.length;

        int[][] newMatrix = new int[len][len];

        for (int i=0; i<len; i++){
            for (int j=0; j<len; j++){
                newMatrix[i][j] = matrix[j][len-1-i];
            }
        }

        return newMatrix;
    }
}

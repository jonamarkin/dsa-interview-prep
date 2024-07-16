package crackingcodinginterview.arraysandstrings;

public class SetZeros {

    /*
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] rotatedMatrix = setZeros(matrix);

        // Print rotated matrix
        for (int[] ints : rotatedMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    public static int[][] setZeros(int[][] matrix){
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i=0; i< matrix.length; i++){
            for (int j =0; j<matrix[0].length; j++){
                if (matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        //Now set entire row or columns to 0 if one of the elements is 0
        for (int i=0; i< row.length; i++){
            for (int j =0; j<col.length; j++){
                if (row[i]==1 || col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }

        return matrix;
    }
}

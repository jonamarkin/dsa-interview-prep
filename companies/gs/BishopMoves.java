package companies.gs;

public class BishopMoves {

    /*
    Given the position of a Bishop (A, B) on an 8 * 8 chessboard. Your task is to count the total number of squares that can be visited by the Bishop in one move.
    The position of the Bishop is denoted using row and column number of the chessboard.
     */
    public static int bishopMoves(int A, int B){
        //Bishop can move in any of the four diagonal directions
        int topLeft = Math.min(A-1, B-1);
        int topRight = Math.min(A-1, 8-B);
        int bottomLeft = Math.min(8-A, B-1);
        int bottomRight = Math.min(8-A, 8-B);

        return topLeft + topRight + bottomLeft + bottomRight;
    }

    public static void main(String[] args) {
        System.out.println(bishopMoves(3, 2));
    }
}

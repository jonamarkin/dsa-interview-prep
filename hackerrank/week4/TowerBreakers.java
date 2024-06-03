package hackerrank.week4;

public class TowerBreakers {

    public static void main(String[] args) {
        System.out.println(towerBreakers(2, 6));
    }

    /*
    If the height of each tower m is 1, Player 1 has no move to make because a tower of height 1 cannot be reduced further. Therefore, Player 1 loses immediately.
    If m is greater than 1, we need to consider the number of towers n.

    When n is odd, Player 1 can always force a win by making a move that mirrors Player 2's actions (by copying the moves but always staying one step ahead).
    When n is even, Player 2 can mirror Player 1's moves, forcing Player 1 to face the situation as if they were the second player in an odd n scenario.
     */

    public static int towerBreakers(int n, int m) {
        // Write your code here
        if (m == 1) {
            return 2;
        }

        return n % 2 == 0 ? 2 : 1;

    }
}

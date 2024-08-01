package leetcode.blind75.binarysearch;

public class GuessGame {

    /*
    We are playing the Guess Game. The game is as follows:

    I pick a number from 1 to n. You have to guess which number I picked.

    Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

    You call a pre-defined API int guess(int num), which returns three possible results:

    -1: Your guess is higher than the number I picked (i.e. num > pick).
    1: Your guess is lower than the number I picked (i.e. num < pick).
    0: your guess is equal to the number I picked (i.e. num == pick).
    Return the number that I picked.
     */

    public int guessNumber(int n) {

        int start  = 1;
        int end = n;
        int answer = 0;
        int middle;

        while (start <= end){
            middle = (start + n)/2;
            if (guess(middle) == -1){
                end = middle-1;
            }
            else if (guess(middle) == 1){
                start = middle +1;
            } else if (guess(middle)==0) {
                answer = middle;
                break;
            }
        }

        return answer;
    }

    private int guess(int n) {
        return -1;
    }
}

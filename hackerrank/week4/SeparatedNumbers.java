package hackerrank.week4;

public class SeparatedNumbers {

    public static void main(String[] args) {

    }

    /*

    To implement this in code, you would typically try the following approach:

    Iterate Over Possible First Numbers: Starting from the beginning of the string, consider each possible first number.
    The length of the first number can be at most half of the string length (since there must be at least two numbers).
    Check Sequential Increases: For each first number candidate, calculate the next number in the sequence,
    check if it immediately follows the first in the string, and continue this process through the rest of the string.
    Validate No Leading Zeros: Ensure that numbers don't have leading zeros unless they are "0" itself.
    Complete String Verification: If the entire string is used up by following the sequence, the string is beautiful.
    If you reach a point where the sequence fails (either a number does not follow immediately, or there is a format error),
    move to the next candidate first number.
     */

    public static void separateNumbers(String s) {
        // Write your code here

        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {  // i is the length of the first number
            long firstNumber = Long.parseLong(s.substring(0, i));
            if (s.charAt(0) == '0' && i > 1)  // Skip if the first number has leading zero and is not '0'
                continue;

            boolean beautiful = true;
            long currentNumber = firstNumber;
            int startIndex = i;
            while (startIndex < n) {
                long nextNumber = currentNumber + 1;
                String nextNumberStr = Long.toString(nextNumber);
                int nextNumberLength = nextNumberStr.length();
                if (startIndex + nextNumberLength > n ||
                        !s.substring(startIndex, startIndex + nextNumberLength).equals(nextNumberStr)) {
                    beautiful = false;
                    break;
                }
                startIndex += nextNumberLength;
                currentNumber = nextNumber;
            }

            if (beautiful && startIndex == n) {
                System.out.println("YES " + firstNumber);
                return;
            }
        }
        System.out.println("NO");
    }
}

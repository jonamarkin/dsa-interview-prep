package faang.amazon;

public class ReverseInteger {

    /*
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     */

    public int reverse(int x) {
        String srtX = ""+x;
        char[] stringArr = srtX.toCharArray();

        int start = 0;
        int end = stringArr.length-1;

        while(start<end){
            char temp = stringArr[start];
            stringArr[start] = stringArr[end];
            stringArr[end] = temp;

            start++;
            end--;
        }


        return 0;
    }
}

package faang.aptus;

import java.util.Arrays;

public class PlusOne {

    /*
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
    The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

    Increment the large integer by one and return the resulting array of digits.
     */

    public static void main(String[] args) {
        int[] arr = new int[]{8,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {

        /*
        Loop from right to left
        If the number encountered is less than 9 just increment it and return the digits array

        If not less than 9 then you will have to set that number to zero and increment the number before it instead
        Increasing the next number is handled automatically by the loop so all we have to do is to set to zero if its not less than 9

        After the loop has finished without returning then it means there is a 1 that needs to be appended in front of the digits
        Because arrays cannot be changed after they have been declared,  we need to create a new array and put the elements in it, setting the first element to zero


         */
        for (int i = digits.length-1; i >=0; i--){
            if (digits[i]<9){
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        //This creates a new array with length of the digits array + 1 and by default sets all values to zero
        //So we just need to change the first index to 1
        digits = new int[digits.length + 1];

        digits[0]=1;
        return digits;

        /*
        Another way  - Copying the elements from the first into the second one starting from pos 1 in the second one

        int[] digitsNew = new int[digits.length + 1];
        System.arraycopy(digits,0,digitsNew, 1, digits.length);

        digitsNew[0]=1;
        return digitsNew;

         */

    }
}

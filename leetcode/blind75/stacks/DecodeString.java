package leetcode.blind75.stacks;

import java.util.Stack;

public class DecodeString {

    /*
    Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
    Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
    For example, there will not be input like 3a or 2[4].
     */
    public static void main(String[] args) {

    }

    /*
    Use two stacks
    One for the
     */

    public static String decodeString(String encodedString){

        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        int k = 0;
        StringBuilder currentString = new StringBuilder();

        for (char c: encodedString.toCharArray()){
            if (Character.isDigit(c)){
                //Calculate the full digit
                k = k*10 + Character.getNumericValue(c);
            } else if (c=='[') {
                integerStack.push(k);
                stringStack.push(currentString);

                k=0;
                currentString = new StringBuilder();

            } else if (c==']') {
                StringBuilder decodedString = stringStack.pop();
                int repetition = integerStack.pop();

                decodedString.append(String.valueOf(currentString).repeat(Math.max(0, repetition)));

                currentString = decodedString;

            }else{
                currentString.append(c);
            }
        }


        return currentString.toString();
    }
}

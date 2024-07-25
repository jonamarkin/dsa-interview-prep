package leetcode.blind75.arraysandstrings;

import java.util.HashSet;

public class ReverseVowels {

    /*
    Given a string s, reverse only all the vowels in the string and return it.

    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     */
    public static void main(String[] args) {

        String str =  "hello";

        System.out.println(reverseVowels(str));
    }

    public static String reverseVowels(String s) {

        char[] charArray = s.toCharArray();

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');


        int leftPointer = 0;
        int rightPointer = charArray.length-1;

        while (leftPointer < rightPointer){

            boolean leftCheck;
            boolean rightCheck;
            if (vowels.contains(charArray[leftPointer])){
                leftCheck = true;
            }else{
                leftPointer++;
                leftCheck = false;
            }

            if (vowels.contains(charArray[rightPointer])){
                rightCheck = true;
            }else{
                rightPointer--;
                rightCheck = false;
            }

            if (leftCheck && rightCheck){
                char temp = charArray[leftPointer];
                charArray[leftPointer] = charArray[rightPointer];
                charArray[rightPointer] = temp;

                rightPointer--;
                leftPointer++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c: charArray){
            stringBuilder.append(c);
        }

        return stringBuilder.toString();

    }
}

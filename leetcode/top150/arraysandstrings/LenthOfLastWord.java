package leetcode.top150.arraysandstrings;

public class LenthOfLastWord {
    /*
    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.
     */

    public int lengthOfLastWord(String s) {
        // String[] arr = s.split(" ");
        // //System.out.println(arr);

        // return arr[arr.length-1].trim().length();



        int len = 0;
        int i = s.length()-1;

        while(i>=0 && s.charAt(i)== ' '){
            i--;
        }

        while(i>=0 && s.charAt(i)!= ' '){
            len++;
            i--;
        }

        return len;
    }
}

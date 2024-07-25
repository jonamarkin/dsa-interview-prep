package leetcode.blind75.arraysandstrings;

public class MergeStringsAlternately {

    /*
    You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
    If a string is longer than the other, append the additional letters onto the end of the merged string.

    Return the merged string.
     */

    public static void main(String[] args) {

        System.out.println(mergeAlternately("abc", "ddeeff"));
    }


    public static String mergeAlternately(String word1, String word2) {

        StringBuilder stringBuilder = new StringBuilder();

        int maxLength = Math.max(word1.length(), word2.length());

        for (int i=0; i<maxLength; i++){

            if (i < word1.length()){
                stringBuilder.append(word1.charAt(i));
            }

            if (i <word2.length()){
                stringBuilder.append(word2.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}

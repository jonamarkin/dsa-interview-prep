package crackingcodinginterview.arraysandstrings;


public class Anagrams {

    /*
    Write a method to decide if two strings are anagrams or not
     */

    public static void main(String[] args) {
        String first = "anagram";
        String second = "nagramc";

        System.out.println(anagrams(first, second));
    }


    public static boolean anagrams(String firstString, String secondString){
        int[] charsCount = new int[256];

        if (firstString.length()!= secondString.length()){
            return false;
        }

        for (int i = 0; i<firstString.length(); i++){
            int charInt = firstString.charAt(i);
            charsCount[charInt]++;
        }

        for (int i = 0; i<secondString.length(); i++){
            int charInt = secondString.charAt(i);
            charsCount[charInt]--;
        }

        for (int val: charsCount){
            if (val!=0) return false;
        }
        return true;
    }


    /*
    I can  also sort the two strings and compare the values at various indexes
     */
}

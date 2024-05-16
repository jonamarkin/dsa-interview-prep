package slightlie_techie;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        String first = "anagram";
        String second = "nagrama";

        System.out.println(validAnagram(first, second));
    }

    public static boolean validAnagram(String s, String t){
        char[] firstString = s.toCharArray();
        char[] secondString = t.toCharArray();

        if(firstString.length!= secondString.length){
            return false;
        }

        Arrays.sort(firstString);
        Arrays.sort(secondString);

        for (int i =0; i<firstString.length; i++){
            if (firstString[i] != secondString[i]){
                return false;
            }
        }

        return true;
    }
}

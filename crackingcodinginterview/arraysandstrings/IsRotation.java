package crackingcodinginterview.arraysandstrings;

public class IsRotation {

    /*
    Assume you have a method isSubstring which checks if one word is a substring of another.
    Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
     */

    public static void main(String[] args) {

    }


    /*
    Check if the lengths are the same
    If not return false immediately


    Else create a circular version of of s1 by appending s1 to itself
    Then call the isSubstring function to check if it is a substring of it
     */
    public static boolean isRotation(String s1, String s2){
        if (s1.length()!=s2.length() && !(s1.length() >0)) return false;

        String circulars1 = s1+s1;

        return isSubString(circulars1, s2);
    }

    private static boolean isSubString(String circulars1, String s2) {
    }
}

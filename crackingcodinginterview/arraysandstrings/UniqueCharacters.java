package crackingcodinginterview.arraysandstrings;

import java.util.HashSet;

public class UniqueCharacters {
    public static void main(String[] args) {

        System.out.println(allUnique("string"));
    }

    /*
    Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
     */

    public static boolean checkUnique(String string) {

        HashSet<Character> characterHashSet = new HashSet<>();

        for (char c : string.toCharArray()) {
            if (characterHashSet.contains(c)) {
                return false;
            }
            characterHashSet.add(c);
        }

        return true;
    }


    public static boolean allUnique(String str) {
        boolean[] chars = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            int charInt = str.charAt(i);

            System.out.println(charInt);

            if (chars[charInt]) {
                return false;
            }

            chars[charInt] = true;
        }

        return true;
    }

    /*
    Other methods
    - Use two loops with will give On^2
    - Sort and then scan from left to right Onlogn
    - Read the characters of the string into a hashset and compare the hashset length to the string length

     */

}

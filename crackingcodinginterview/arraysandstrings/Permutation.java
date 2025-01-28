package crackingcodinginterview.arraysandstrings;

public class Permutation {

    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "bca"));
    }

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] letters = new int[128];

        for (char c : s1.toCharArray()) {
            letters[c]++;
        }

        for (char c : s2.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}

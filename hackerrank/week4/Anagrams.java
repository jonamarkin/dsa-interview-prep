package hackerrank.week4;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(anagram("abccde"));
    }

    public static int anagram(String s) {
        // Check if the string has an even length
        if (s.length() % 2 != 0) {
            return -1;
        }

        // Get the length of one substring (half of the string)
        int halfLength = s.length() / 2;

        // Create a character count array to store the frequency of each character in the first substring
        int[] charFreq = new int[26];
        for (char c : s.substring(0, halfLength).toCharArray()) {
            charFreq[c - 'a']++; // Use char arithmetic to get index for lowercase letters
        }

        // Count the number of characters that need to be changed to make the substrings anagrams
        int changes = 0;
        for (char c : s.substring(halfLength).toCharArray()) {
            int index = c - 'a';
            if (charFreq[index] > 0) {
                charFreq[index]--;
            } else {
                changes++;
            }
        }

        return changes;
    }
}

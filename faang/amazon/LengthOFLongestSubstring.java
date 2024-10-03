package faang.amazon;

import java.util.HashSet;
import java.util.Set;

public class LengthOFLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }


    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seenChars = new HashSet<>();
        int longest = seenChars.size();

        for (char c : s.toCharArray()) {
            if (seenChars.contains(c)) {
                longest = Math.max(longest, seenChars.size());
                seenChars.clear();
            }

            seenChars.add(c);
        }

        return longest;
    }
}

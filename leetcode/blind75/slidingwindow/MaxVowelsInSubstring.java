package leetcode.blind75.slidingwindow;

import java.util.HashSet;

public class MaxVowelsInSubstring {

    /*
    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

    Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
     */

    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        StringBuilder sb = new StringBuilder();
        int maxVowels = Integer.MIN_VALUE;
        int vowelCount = 0;
        for(int i=0; i<k; i++){
            char c = s.charAt(i);
            sb.append(c);
            if(vowels.contains(c)){
                vowelCount++;
            }
        }

        maxVowels = vowelCount;

        for(int i = k; i<s.length(); i++){
            char c = sb.charAt(0);
            if(vowels.contains(c)){
                vowelCount--;
            }
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));

            if(vowels.contains(s.charAt(i))){
                vowelCount++;
            }

            maxVowels = Math.max(vowelCount, maxVowels);
        }

        return maxVowels;
    }


    //Little tweak in second solution optimizes performance greatly. No extra use of space fo keep track of the substrings
    public int maxVowels2(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int maxVowels = 0;
        int vowelCount = 0;
        for(int i=0; i<k; i++){
            if(vowels.contains(s.charAt(i))){
                vowelCount++;
            }
        }

        maxVowels = vowelCount;

        for(int i = k; i<s.length(); i++){

            if(vowels.contains(s.charAt(i-k))){
                vowelCount--;
            }


            if(vowels.contains(s.charAt(i))){
                vowelCount++;
            }

            maxVowels = Math.max(vowelCount, maxVowels);
        }

        return maxVowels;
    }
}

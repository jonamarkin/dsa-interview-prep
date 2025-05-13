package leetcode.top150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    /*
    Given a pattern and a string s, find if s follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.


    Example 1:

    Input: pattern = "abba", s = "dog cat cat dog"

    Output: true

    Explanation:

    The bijection can be established as:

    'a' maps to "dog".
    'b' maps to "cat".
    Example 2:

    Input: pattern = "abba", s = "dog cat cat fish"

    Output: false

    Example 3:

    Input: pattern = "aaaa", s = "dog cat cat dog"

    Output: false
     */

    class Solution {
        public boolean wordPattern(String pattern, String s) {

            Map<Character, String> patternMap = new HashMap<>();
            Map<String, Character> stringMap = new HashMap<>();

            char[] patternArray = pattern.toCharArray();
            String[] stringArray = s.split(" ");

            if(patternArray.length!=stringArray.length) return false;

            for(int i=0; i<patternArray.length; i++){
                char c = patternArray[i];
                String str = stringArray[i];

                if(patternMap.containsKey(c)){
                    if(!patternMap.get(c).equals(str)){
                        return false;
                    }
                }else{
                    patternMap.put(c, str);
                }

                if(stringMap.containsKey(str)){
                    if(stringMap.get(str)!=c){
                        return false;
                    }
                }else{
                    stringMap.put(str, c);
                }

            }

            return true;
        }
    }


    //Try to use equals when comparing strings
}

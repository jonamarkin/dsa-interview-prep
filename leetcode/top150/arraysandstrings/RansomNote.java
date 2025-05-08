package leetcode.top150.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    /*
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

    Each letter in magazine can only be used once in ransomNote.
     */

    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : ransomNote.toCharArray()){
            if (!map.containsKey(c) || map.get(c)==0){
                return false;
            }

            map.put(c, map.get(c)-1);
        }

        return true;
    }
}

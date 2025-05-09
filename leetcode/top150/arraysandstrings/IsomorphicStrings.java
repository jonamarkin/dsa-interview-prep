package leetcode.top150.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    /*
    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.
     */

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;

        Map<Character, Character> sMapToT = new HashMap<>();
        Map<Character, Character> tMapToS = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if(sMapToT.containsKey(schar)){
                if(sMapToT.get(schar)!=tchar){
                    return false;
                }
            }else{
                sMapToT.put(schar,tchar);
            }

            if(tMapToS.containsKey(tchar)){
                if(tMapToS.get(tchar)!=schar){
                    return false;
                }
            }else{
                tMapToS.put(tchar,schar);
            }
        }

        return true;
    }


    public boolean isIsomorphic2(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] sToT = new int[256];
        int[] tToS = new int[256];

        Arrays.fill(sToT, -1);
        Arrays.fill(tToS, -1);

        for(int i=0; i<s.length(); i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if(sToT[schar]==-1){
                sToT[schar] = tchar;
            }else{
                if( sToT[schar] != tchar){
                    return false;
                }
            }

            if(tToS[tchar]==-1){
                tToS[tchar] = schar;
            }else{
                if( tToS[tchar] != schar){
                    return false;
                }
            }
        }

        return true;
    }
}

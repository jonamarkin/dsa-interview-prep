package crackingcodinginterview.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    /*
    Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
    The palindrome does not need to be limited to just dictionary words.
    EXAMPLE
    Input: Tact Coa
    Output: True (permutations: "taco cat'; "atco eta·; etc.)

     */

    public boolean isPermutationOfPalindrome(String input){
        int[] permutationCount = new int[128];

        for(char c: input.toLowerCase().toCharArray()){
            if(c != ' '){
                permutationCount[c]++;
            }
        }

        boolean foundOdd = false;
        for(int count: permutationCount){
            if(count % 2 == 1){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }


    public boolean isPermutationOfPalindrome2(String input){
        int[] permutationCount = new int[128];

        int oddCount = 0;

        for(char c: input.toLowerCase().toCharArray()){
            if(c != ' '){
                permutationCount[c]++;
            }

            if(permutationCount[c] % 2 == 1){
                oddCount++;
            }
            else{
                oddCount--;
            }
        }

        return oddCount <= 1;
    }

    public boolean isPermutationOfPalindrome3(String input){
        Map<Character, Integer> charCountMap = new HashMap<>();

        for(char c: input.toLowerCase().toCharArray()){
            if(c != ' '){
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }

        int oddCount = 0;
        for(int count: charCountMap.values()){
            if(count % 2 == 1){
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.isPermutationOfPalindrome("Tact Coa")); // true
        System.out.println(pp.isPermutationOfPalindrome2("Tact Coa")); // true
        System.out.println(pp.isPermutationOfPalindrome3("Tact Coa")); // true
    }
}

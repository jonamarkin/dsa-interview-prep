package leetcode.blind75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    private static final String[] LETTER ={
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits ==null || digits.length() ==0){
            return result;
        }

        backtrack(result, new StringBuilder(), digits, 0);
        return result;


    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        if (index == digits.length()){
            result.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = LETTER[digit];

        for (char letter : letters.toCharArray()){
            current.append(letter);
            backtrack(result, current, digits, index+1);
            current.setLength(current.length()-1);
        }
    }
}

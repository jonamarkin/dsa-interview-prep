package leetcode.blind75.stacks;

import java.util.Stack;

public class RemoveStars {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }

    public static String removeStars(String s) {

        Stack<Character> characterStack = new Stack<>();

        for (char c: s.toCharArray()){

                //If not empty check if current character is a star and pop from the stack
                if (c=='*'){
                    if (!characterStack.isEmpty()){
                        characterStack.pop();
                    }

                }else{
                    characterStack.push(c);
                }

        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : characterStack){
            stringBuilder.append(c);
        }

        return stringBuilder.toString();

    }
}

package hackerrank.challenges;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {

        String first = "{[()]}";
        String second = "{[(])}";
        String third = "{{[[(())]]}}";

        System.out.println(isBalanced_Stack(first));
        System.out.println(isBalanced_Stack(second));
        System.out.println(isBalanced_Stack(third));
    }

    public static String isBalanced_Stack(String s) {
        // Write your code here


        if (s.isEmpty() || !(s.length()%2==0)){
            return "NO";
        }

        Stack<Character> bracketStack = new Stack<>();

        for (char c : s.toCharArray()){
            if (!(c=='{' || c=='[' || c=='(' || c=='}' || c ==']' || c== ')')){
                return "NO";
            }

            if (c=='{' || c=='[' || c=='('){
                bracketStack.push(c);
            }else{
                if (bracketStack.isEmpty()){
                    return "NO";
                }

                char top = bracketStack.pop();

                if((c=='}' && top!='{') || (c==']' && top!='[') || (c==')' && top!='(')){
                    return "NO";
                }
            }

        }


        System.out.println(bracketStack.size());

        return bracketStack.isEmpty() ? "YES" : "NO";

    }
}

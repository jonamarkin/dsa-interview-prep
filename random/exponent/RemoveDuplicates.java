package random.exponent;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicates {

    /*
    Remove Adjacent Duplicates in String. You are given a string s and an integer k.
    Write a function to remove k adjacent duplicates from s where the "adjacent" characters are equal.

    For instance, if k is 3 and the string is "daaabbbaa", since we have "aaa" and "bbb" as adjacent triples,
    the function should transform the string to "daa", removing the "bbb" first and then the remaining "aaa".

    s = 'abcd'
    k = 2
    output: 'abcd'

    s = 'deeedbbcccbdaa'
    k = 3
    output: 'aa'

    s = 'pbbcggttciiippooaais'
    k = 2
    output: 'ps'

    s = 'aaabbbacd'
    k = 3
    output: 'acd'
     */

    public static String identifyAdjacent(String s, int k) {
        // your code goes here

        Deque<Pair> stack  = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().ch==c){
                stack.peek().count++;
                if(stack.peek().count==k){
                    stack.pop();
                }
            }else{
                stack.push(new Pair(c,1));
            }

        }


        //Construct the string

        StringBuilder sb = new StringBuilder();
        for(Pair p: stack){
            for(int i=0; i<p.count; i++){
                sb.append(p.ch);
            }
        }

        return sb.reverse().toString();
    }

    static class Pair{
        char ch;
        int count;

        public Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        // debug your code below

        System.out.println(identifyAdjacent("abcd", 2));
    }
}

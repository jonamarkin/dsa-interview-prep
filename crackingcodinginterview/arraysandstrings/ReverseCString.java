package crackingcodinginterview.arraysandstrings;

import javax.xml.stream.events.Characters;

public class ReverseCString {
    public static void main(String[] args) {
        System.out.println(reverseString("abcd"));
        char[] chars = {'a','b','c','d',Character.MIN_VALUE};
        //char[] chars = {'a','b','c','d','\0'};

        System.out.println(reverseCString(chars));
    }

    /*
    Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
     */


    public static String reverseString(String str){
        StringBuilder stringBuilder = new StringBuilder();

        //Character emptyChar = Character.MIN_VALUE;
        //stringBuilder.append(emptyChar);

        for (int i = str.length()-1; i>=0; i--){
            stringBuilder.append(str.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static char[] reverseCString(char[] str){
        int len = str.length;
        int start = 0;
        int end = str.length-2; //To remove the null character at the end of the C-style string

        while(start<end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++;
            end--;
        }

        return str;
    }
}

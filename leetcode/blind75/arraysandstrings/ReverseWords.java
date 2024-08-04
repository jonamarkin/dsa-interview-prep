package leetcode.blind75.arraysandstrings;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {

        //Trim the string to remove trailing spaces
        s = s.trim();

        String[] words = s.split("\\s+");

        int left = 0;
        int right = words.length-1;

        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left ++;
            right --;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i < words.length; i++){
            stringBuilder.append(words[i]);
            if (i < words.length-1){
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}

package random;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SubstringsOfLength {

    /*
    Given a string return all the possible substrings of length k
     */

    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(subStrings4(s, 3));

    }

    /*
    Dumb solution: Generate all possible substrings and check for that ones that meet the length requirement
     */
    public static List<String> subStrings1(String s, int k){
        List<String> result = new ArrayList<>();

        if (k<=0 || k>s.length()){
            return result;
        }

        for (int i=0; i<s.length(); i++){
            for (int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i,j);

                if (sub.length()==k){
                    result.add(sub);
                }
            }
        }

        return result;
    }



    /*
    Sliding Window Approach
     */
    public static List<String> subStrings2(String s, int k) {
        List<String> result = new ArrayList<>();

        if (k <= 0 || k > s.length()) {
            return result;
        }

        for (int i=0; i<=s.length()-k; i++){
            result.add(s.substring(i, i+k));
        }

        return result;
    }

    /*
    Using Deque Approach
     */

    public static List<String> subStrings3(String s, int k) {
        List<String> result = new ArrayList<>();

        if (k <= 0 || k > s.length()) {
            return result;
        }

        Deque<Character> deque = new LinkedList<>();
        for (int i=0; i<s.length(); i++){
            deque.addLast(s.charAt(i));

            if (deque.size() ==k){
                StringBuilder sb = new StringBuilder();
                for (char c : deque){
                    sb.append(c);
                }
                result.add(sb.toString());
                deque.removeFirst();
            }
        }


        return result;

    }

    /*
    Precompute using String Builder
    Like prefix sums and so on
     */
    public static List<String> subStrings4(String s, int k) {
        List<String> result = new ArrayList<>();

        if (k <= 0 || k > s.length()) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<k; i++){
            sb.append(s.charAt(i));
        }
        result.add(sb.toString());

        for (int i=k;i<s.length();i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            result.add(sb.toString());
        }

        return result;
    }


}

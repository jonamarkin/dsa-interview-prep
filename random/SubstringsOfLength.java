package random;

import java.util.ArrayList;
import java.util.List;

public class SubstringsOfLength {

    /*
    Given a string return all the possible substrings of length k
     */

    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(subStrings1(s, 3));

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




}

package hackerrank.week2;

import java.util.HashMap;
import java.util.Map;

public class Pangram {
    public static void main(String[] args) {

        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));

    }

    public static String pangrams(String s) {
        HashMap<Character, Integer> alphabetHashMap = new HashMap<>();

        boolean pangram = true;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabetHashMap.put(ch, 0);
        }

        // alphabetHashMap.forEach((key, value) -> System.out.println(key + " - " +
        // value));

        s = s.replace(" ", "");

        s = s.toLowerCase();

        for (char ch : s.toCharArray()) {
            alphabetHashMap.put(ch, alphabetHashMap.getOrDefault(ch, 0) + 1);

        }

        for (Map.Entry<Character, Integer> entry : alphabetHashMap.entrySet()) {
            if (entry.getValue() == 0) {
                pangram = false;
                break;
            }
        }

        return pangram ? "pangram" : "not pangram";

    }
}

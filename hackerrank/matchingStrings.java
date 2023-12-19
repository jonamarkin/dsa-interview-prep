package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class matchingStrings {

    public static void main(String[] args) {
        List<String> strings = List.of("ab", "abc", "ab");
        List<String> queries = List.of("ab", "abc", "bc");
        List<Integer> matchStr = matchingStrings(strings, queries);
        System.out.println(matchStr);
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Use Hashmap to store the strings and their frequencies
        // Then I can just query them in 0(1) time from the hashmap

        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String string : strings) {
            frequencyMap.put(string, frequencyMap.getOrDefault(string, 0) + 1);
        }

        // Create list for the output
        List<Integer> stringFreq = new ArrayList<>();
        // Loop through queries and check for their frequencies in the frequency map
        for (String query : queries) {
            stringFreq.add(frequencyMap.getOrDefault(query, 0));
        }

        return stringFreq;
    }
}

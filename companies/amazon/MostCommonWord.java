package companies.amazon;

import java.util.*;

public class MostCommonWord {

    /*
    Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
    It is guaranteed there is at least one word that is not banned, and that the answer is unique.

    The words in paragraph are case-insensitive and the answer should be returned in lowercase.
     */
    public String mostCommonWord(String paragraph, String[] banned) {

        String normalizedParagraph = paragraph.toLowerCase().replaceAll("[!?',;\\.]", " ");

        String[] words = normalizedParagraph.split("\\s+");

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words){
            if (!bannedSet.contains(word) && !word.isEmpty()){
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0)+1);
            }
        }

        String mostCommon = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()){
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }
}

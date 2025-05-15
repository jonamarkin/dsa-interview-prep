package random.exponent;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;


public class MostCommonWords {

    /*
    We want to find the most frequently used words in a long string of text.
    Write a function most_common_words(text) that returns an array containing words with their frequencies,
    sorted from most common to least common, with ties broken by alphabetic order.

    For greater accuracy, your solution should ignore punctuation and capitalization.
     */

    public static String[][] mostCommonWords(String text) {
        // your code goes here

        if (text == null || text.trim().isEmpty()) return new String[0][0];

        //Remove not-alpha and non-spaces
        text = text.toLowerCase().replaceAll("[^a-z\\s]", " ");

        String[] words = text.trim().split("\\s+");

        //Count freqs
        Map<String, Integer> freqMap = new HashMap<>();

        for(String word: words){
            freqMap.put(word, freqMap.getOrDefault(word, 0)+1);
        }

        //convert map entries into a list and sort
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());

        list.sort((a,b)->{
            int freq = b.getValue().compareTo(a.getValue());
            if(freq ==0){
                freq = a.getKey().compareTo(b.getKey());
            }
            return freq;
        });

        String[][] result = new String[list.size()][2];

        for(int i=0; i<list.size(); i++){
            result[i][0] = list.get(i).getKey();
            result[i][1] = String.valueOf(list.get(i).getValue());
        }

        return result;

    }

    public static void main(String[] args) {
        // debug your code below
        String text = "It was the best of times, it was the worst of times.";
        String[][] result = mostCommonWords(text);
        System.out.println("Most Common Words:");
        for (String[] pair : result) {
            System.out.println(pair[0] + ": " + pair[1]);
        }
    }
}

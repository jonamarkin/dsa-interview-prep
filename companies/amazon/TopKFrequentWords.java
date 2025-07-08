package companies.amazon;

import java.util.*;

public class TopKFrequentWords {

    /*
    Given an array of strings words and an integer k, return the k most frequent strings.

    Return the answer sorted by the frequency from highest to lowest. Sort the words with
    the same frequency by their lexicographical order.
     */

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>((word1, word2)->{
            int comparison = frequencyMap.get(word1) - frequencyMap.get(word2);
            if (comparison==0){
                return word2.compareTo(word1);
            }
            return comparison;
        });

        for (String word: frequencyMap.keySet()){
            priorityQueue.offer(word);
            if (priorityQueue.size() >k){
                priorityQueue.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            result.add(priorityQueue.poll());
        }
        Collections.reverse(result);
        return result;

    }
}

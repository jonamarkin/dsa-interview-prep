package companies.gs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ApacheLogAnalyzer {

    public Map<String, Integer> getIpFrequencies(String logFilePath) throws FileNotFoundException {
        Map<String, Integer> ipFrequencies = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                if(tokens.length > 0){
                    String ipAddress = tokens[0];
                    ipFrequencies.put(ipAddress, ipFrequencies.getOrDefault(ipAddress, 0) + 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ipFrequencies;
    }

    public List<Map.Entry<String, Integer>> getTopKMostFrequentIps(Map<String, Integer> ipFrequencies, int k){

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey)
        );

        for (Map.Entry<String, Integer> entry: ipFrequencies.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(entry);
            }else if (entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }


        List<Map.Entry<String, Integer>> result = new ArrayList<>(minHeap);
        Collections.reverse(result);
        return result;
    }
}

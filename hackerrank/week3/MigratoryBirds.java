package hackerrank.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MigratoryBirds {

    /*
    TODO:
    Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type.
    If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
     */


    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxValue = 0;
        for(int birdType: arr){
            hashMap.put(birdType, hashMap.getOrDefault(birdType, 0)+1);
            maxValue = Math.max(maxValue, hashMap.get(birdType));
        }

        int mostFrequentBirdType = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if(entry.getValue() == maxValue){
                mostFrequentBirdType = Math.min(mostFrequentBirdType, entry.getKey());
            }
        }

        return mostFrequentBirdType;
    }



    public static void main(String[] args) {
        List<Integer> list = Stream.of(3,2,1,2,3,4).collect(Collectors.toList());
        System.out.println(migratoryBirds(list));
    }
}

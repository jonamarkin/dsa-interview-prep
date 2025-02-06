package leetcode.top150.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> numFreq = new HashMap<>();
        int n = nums.length;
        int floorVal = n/2;

        for(int num: nums){
            numFreq.put(num, numFreq.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: numFreq.entrySet()){
            if(entry.getValue() > floorVal){
                return entry.getKey();
            }
        }

        return 0;
    }
}

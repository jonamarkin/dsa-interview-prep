package leetcode.blind75.hashmapandset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArrayDifference {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        HashSet<Integer> nums2Set = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        for (int num : nums2) {
            nums2Set.add(num);
        }

        List<Integer> distinct1 = new ArrayList<>();
        List<Integer> distinct2 = new ArrayList<>();

        for(int num : nums1Set){
            if(!nums2Set.contains(num)){
                distinct1.add(num);
            }
        }

        for(int num : nums2Set){
            if(!nums1Set.contains(num)){
                distinct2.add(num);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(distinct1);
        result.add(distinct2);

        return result;
    }
}

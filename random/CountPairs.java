package random;

import java.util.List;
import java.util.stream.Stream;

public class CountPairs {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(-1,1,2,3,1).toList();
        System.out.println(countPairs(list, 2));
    }

    /*
    Count pairs whose sum is less than a target
    Given a 0-indexed integer array nums of length n and an integer target, return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.
     */

    public static int countPairs(List<Integer> nums, int target) {
        int numPairs = 0;

        for(int i= 0; i<nums.size()-1; i++){
            for (int j = i+1; j <nums.size(); j++){
                if (nums.get(i) +nums.get(j) < target){
                    numPairs ++;
                }
            }
        }
        return numPairs;
    }


    //Better solution
    public static int countPairsOpt(List<Integer> nums, int target) {
        int numPairs = 0;

        for(int i= 0; i<nums.size()-1; i++){
            for (int j = i+1; j <nums.size(); j++){
                if (nums.get(i) +nums.get(j) < target){
                    numPairs ++;
                }
            }
        }
        return numPairs;
    }
}

package random;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountPairs {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(-1,1,2,3,1).collect(Collectors.toList());
        System.out.println(countPairsOpt(list, 2));
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
    /*
    Use two-pointer solution
    Sort the array as well
    Set the two pointers to the extreme ends of the sorted array
    if the sum is < target. Then it means all pairs in between are also valid
    Then increment the left pointer to the right
    Else decrement the right pointer to the left
     */
    public static int countPairsOpt(List<Integer> nums, int target) {
        Collections.sort(nums);
        int numPairs = 0;
        int leftPointer = 0;
        int rightPointer= nums.size()-1;

        while (leftPointer < rightPointer){
            if (nums.get(leftPointer) + nums.get(rightPointer) < target){
                numPairs += (rightPointer - leftPointer);
                leftPointer++;
            }else{
                rightPointer--;
            }
        }

        return numPairs;
    }
}

package companies.gs;

import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {

    public static List<List<Integer>> generateSubsets(int[] nums, int r){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, r, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int r, int start, List<Integer> current, List<List<Integer>> result){
        if (current.size() == r){
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=start; i<nums.length; i++){
            current.add(nums[i]);
            backtrack(nums, r, i+1, current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int r = 2;
        System.out.println(generateSubsets(nums, r));
    }
}

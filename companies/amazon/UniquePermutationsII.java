package companies.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort the array to facilitate duplicate skipping.
        Arrays.sort(nums);
        // Step 2: Create a boolean array to track the used elements.
        boolean[] used = new boolean[nums.length];
        // Step 3: Start backtracking to generate permutations.
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: If the current permutation has the same length as nums, add it to result.
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip this element if it has already been used in the current permutation.
            if (used[i]) continue;

            // Skip this element if it's a duplicate of the previous one and the previous one hasn't been used.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Choose the element nums[i].
            current.add(nums[i]);
            used[i] = true;

            // Recurse with the chosen element.
            backtrack(nums, current, used, result);

            // Undo the choice for backtracking.
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

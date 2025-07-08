package companies.amazon;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

    /*
    Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the
    remaining elements is divisible by p. It is not allowed to remove the whole array.

    Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

    A subarray is defined as a contiguous block of elements in the array.
     */

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Find the remainder when totalSum is divided by p
        long targetMod = totalSum % p;

        // If the sum is already divisible by p, no need to remove any subarray
        if (targetMod == 0) {
            return 0;
        }

        // HashMap to store the last index of each prefix sum modulo p
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, -1);  // To handle cases where prefix sum itself gives the desired subarray
        long prefixSum = 0;
        int minLen = n;  // Initialize the minimum length as the length of the entire array

        for (int i = 0; i < n; i++) {
            // Update the running prefix sum
            prefixSum += nums[i];

            // Current mod value of the prefix sum
            long currentMod = prefixSum % p;

            // We need (currentMod - targetMod + p) % p to be in prefixMap
            long requiredMod = (currentMod - targetMod + p) % p;

            // If there's a previous prefix sum with the required mod value
            if (prefixMap.containsKey(requiredMod)) {
                int prevIndex = prefixMap.get(requiredMod);
                // Calculate the length of the subarray to remove
                minLen = Math.min(minLen, i - prevIndex);
            }

            // Update the map with the current prefix sum mod value
            prefixMap.put(currentMod, i);
        }

        // Return the result: if minLen is n, it means no valid subarray was found, so return -1
        return minLen == n ? -1 : minLen;
    }
}

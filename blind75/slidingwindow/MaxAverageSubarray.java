package blind75.slidingwindow;

public class MaxAverageSubarray {


    /*
    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
    Any answer with a calculation error less than 10-5 will be accepted.
     */
    public static void main(String[] args) {

    }

    public double findMaxAverage(int[] nums, int k) {

        int len = nums.length;

        double sum = 0;


        /*
        Sliding window technique
        First calculate the sum and average of the first k elements in the array

        Then loop through the array starting from the kth position
        Remove the last item to go out of the scope of k and add the new item entering the scope of k to the sum
        And recalculate the average and compare

        */

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAverage = sum / k;

        for (int i = k; i < len; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxAverage = Math.max(maxAverage, sum / k);
        }

        return maxAverage;


    }
}

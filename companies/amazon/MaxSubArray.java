package companies.amazon;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int globalMax = nums[0];

        for(int i=1; i<nums.length; i++){
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            if(currentMax > globalMax){
                globalMax = currentMax;
            }
        }

        return globalMax;
    }
}

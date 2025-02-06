package leetcode.top150.arraysandstrings;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int writeIndex =1;

        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[writeIndex-1]){
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        return writeIndex;
    }
}

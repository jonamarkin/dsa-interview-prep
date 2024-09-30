package leetcode.blind75.binarysearch;

public class PealElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right){
            int mid = left + (right -left)/2;

            if (nums[mid] > nums[mid+1]){
                //There is a peak in the left half
                right = mid;
            }else{
                //There is a peak in the right half
                left = mid+1;
            }
        }

        return left;
    }
}

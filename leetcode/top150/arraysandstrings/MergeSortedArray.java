package leetcode.top150.arraysandstrings;

public class MergeSortedArray {
    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
    representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
    To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //Shift elements in m to the right
        for(int i=m-1; i>=0; i--){
            nums1[i+n] = nums1[i];
        }

        //Now perform merge sort

        int mPointer = n;
        int nPointer = 0;

        int indexToInsert = 0;

        while(mPointer < m+n && nPointer < n){
            if (nums1[mPointer] < nums2[nPointer]){
                nums1[indexToInsert++] = nums1[mPointer++];
            }else{
                nums1[indexToInsert++] = nums2[nPointer++];
            }
        }


        while (nPointer < n){
            nums1[indexToInsert++] = nums2[nPointer++];
        }

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {


    }
}

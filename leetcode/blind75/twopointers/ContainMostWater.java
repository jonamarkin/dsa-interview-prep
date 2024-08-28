package leetcode.blind75.twopointers;

public class ContainMostWater {

    /*
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.
     */

    /*
    BRUTE FORCE

    Find every possible combination and then determine the one that is the maximum

     */
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        int n = height.length;

        for (int  i=0; i<n; i++){
            for (int j =i+1; j<n; j++){
                int width = j-i;
                int minHeight = Math.min(height[i], height[j]);
                int area = width * minHeight;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;

    }


    public int maxAreaOptimal(int[] height) {
        int maxArea = 0;
        int n = height.length;

        int leftPointer = 0;
        int rightPointer = n-1;

        while (leftPointer<rightPointer){
            int width = rightPointer - leftPointer;
            int minHeight = Math.min(height[leftPointer], height[rightPointer]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            if (height[leftPointer] < height[rightPointer]){
                leftPointer++;
            }else{
                rightPointer--;
            }
        }

        return maxArea;
    }
}

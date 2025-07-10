package companies.gs;

public class SnowPack {

    public static int maxSnow(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        leftMax[0] = heights[0];
        for(int i=1; i<heights.length; i++){
            leftMax[i] = Math.max(heights[i], leftMax[i-1]);
        }

        rightMax[heights.length-1] = heights[heights.length-1];
        for(int i=heights.length-2; i>=0; i--){
            rightMax[i] = Math.max(heights[i], rightMax[i+1]);
        }

        int max = 0;
        for (int i=0; i<heights.length; i++){
            max += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }

        return max;
    }
}

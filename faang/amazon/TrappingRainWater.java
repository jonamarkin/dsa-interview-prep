package faang.amazon;

public class TrappingRainWater {

    public int trapDP(int[] height) {

        // Edge case: if the array has less than 3 bars, no water can be trapped.
        if (height == null || height.length < 3) {
            return 0;
        }

        int n = height.length;
        int totalWater = 0;

        // Create arrays to store the maximum height to the left and right of each bar.
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill the leftMax array.
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill the rightMax array.
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate the trapped water at each bar using precomputed leftMax and rightMax values.
        for (int i = 1; i < n - 1; i++) {
            // Water trapped at current bar = min(leftMax, rightMax) - height[i]
            totalWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return totalWater;

    }


    public int trapBruteForce(int[] height) {
        // Edge case: if the array has less than 3 bars, no water can be trapped.
        if (height == null || height.length < 3) {
            return 0;
        }

        int totalWater = 0;
        int n = height.length;

        for(int i=0; i<n-1; i++){

            int leftMax = 0;
            for(int j=i; j>=0; j--){
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;
            for(int j=i+1; j<n; j++){
                rightMax = Math.max(rightMax, height[j]);
            }

            totalWater+= Math.max(0, Math.min(leftMax, rightMax)-height[i]);
        }

        return totalWater;
    }


    public int trapTwoPointers(int[] height) {
        // Edge case: if the array has less than 3 bars, no water can be trapped.
        if (height == null || height.length < 3) {
            return 0;
        }

        int totalWater = 0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    totalWater+= leftMax - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    totalWater+=rightMax - height[right];
                }
                right--;
            }
        }



        return totalWater;
    }


}

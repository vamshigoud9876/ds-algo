package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

public class TrappingRainWater {

    String img = "com/decodejava/dsa/stackandqueue/resources/trapping_rain_water.png";

    //Time : O(3N) Space: O(2N)
    public int trap(int[] height) {
        int[] rightGreater = new int[height.length];
        int[] leftGreater = new int[height.length];
        int max = 0;
        for(int i = 0; i < leftGreater.length; i++) {
            if (max > height[i]) {
                leftGreater[i] = max;
            } else {
                max = height[i];
            }
        }
        max = 0;
        for(int i = rightGreater.length - 1; i >= 0; i--) {
            if (max > height[i]) {
                rightGreater[i] = max;
            } else {
                max = height[i];
            }
        }

        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            int compute = Math.min(leftGreater[i], rightGreater[i]) - height[i];
            if (compute > 0) ans+=compute;
        }
        return ans;
    }

    String img1 = "com/decodejava/dsa/stackandqueue/resources/trapping_better.png";

    //Time: O(2N) Space: O(N)
    public int trapBetter(int[] height) {
        int[] rightGreater = new int[height.length];
        int max = 0;
        for(int i = rightGreater.length - 1; i >= 0; i--) {
            if (max > height[i]) {
                rightGreater[i] = max;
            } else {
                max = height[i];
            }
        }

        int ans = 0, maxLeft = 0;
        for(int i = 0; i < height.length; i++) {
            int compute = Math.min(maxLeft, rightGreater[i]) - height[i];
            maxLeft = Math.max(maxLeft, height[i]);
            if (compute > 0) ans += compute;
        }
        return ans;
    }

    String img2 = "com/decodejava/dsa/stackandqueue/resources/trapping_optimal.png";

    //Time: O(N) Space: O(1) -- two pointers
    public int trapOptimal(int[] height) {
        int ans = 0, left = 0, right = height.length - 1, prefMax = 0, suffixMax = 0;
        while (left <= right) {
            int compute;
            if (prefMax <= suffixMax) {
                compute  = prefMax - height[left];
                prefMax = Math.max(prefMax, height[left]);
                left++;
            } else {
                compute  = suffixMax - height[right];
                suffixMax = Math.max(suffixMax, height[right]);
                right--;
            }
            if (compute > 0) ans += compute;
        }
        return ans;
    }
}

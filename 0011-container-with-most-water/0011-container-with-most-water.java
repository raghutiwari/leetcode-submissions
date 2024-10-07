class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = Integer.MIN_VALUE;

        while (left < right) {
            // Idea is to take the minimum of two pointers height to calculate the area
            // else the water will spill
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));


            // We need to maximise heigth so we will move the pointer whichever is lower
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
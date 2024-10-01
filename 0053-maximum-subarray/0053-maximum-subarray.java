class Solution {
    public int maxSubArray(int[] nums) {

        // To keep track of maxSum which can be made
        int maxSum = nums[0];

        // To keep track of current Sum of the subArray we are looking into
        int currentSum = nums[0];

        // We iterate through the second element as the first element will be our
        // maxSum and currentSum.
        for (int i = 1; i < nums.length; i++) {
            // Now, we can either include the nums[i] in our subArray
            // or see if just having that element is good enough?
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // We update the maxSum we have encountered so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
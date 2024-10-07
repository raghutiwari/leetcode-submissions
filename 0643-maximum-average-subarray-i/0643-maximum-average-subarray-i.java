class Solution {

    public double findMaxAverage(int[] nums, int k) {
        // Initialise the max average as minimum
        double maxAvg = Double.NEGATIVE_INFINITY;
        // Initialise the windowSum as 0
        double windowSum = 0;

        int n = nums.length;
        // From where we are starting the window
        int start = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the windowSum
            windowSum += nums[i];

            // as soon as the window is equal to number of elements we need in the window
            if ((i - start + 1) == k) {
                // calculate the average
                double avg = windowSum / k;
                // get the max average
                maxAvg = Math.max(maxAvg, avg);
                // We will be shifting the window towards left so remove the first element from the windowSum
                windowSum -= nums[start];
                // Shift the start towards right
                start += 1;
            }
        }

        return maxAvg;

    }


    // Brute Force
    // public double findMaxAverage(int[] nums, int k) {
    //     double maxAvg = Double.NEGATIVE_INFINITY;

    //     for (int i = 0; i <= nums.length - k; i++) {
    //         double sum = 0;
    //         for (int j = i; j < i + k; j++) {
    //             sum += nums[j];
    //         }
    //         double avg = sum/k;
    //         maxAvg = Math.max(maxAvg, avg);
    //     }
        
    //     return maxAvg;
    // }
}
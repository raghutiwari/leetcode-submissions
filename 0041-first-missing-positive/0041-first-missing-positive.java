class Solution {

    public int firstMissingPositive(int[] nums) {
        // The missing number will always be in the range of 1 to (nums.length + 1)
        // WHy?
        // Because if no number is missing than 1 to N will occupy all the spaces in the array and the minimum would be N + 1

        // So, we will use the appraoch of in-memory modification
        // And keep the number x of an array at the index x - 1 if it is positive and within the range of N.
        // If not, then we don't care.
        // Then we will return the first number x in the array for which
        // nums[x] != x + 1 as we have made some changes in the beginning.

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    //Time Complexity: T(N) and space: T(N)
    // public int firstMissingPositive(int[] nums) {
    
    //     boolean[] visited = new boolean[nums.length + 1];

    //     for (int n : nums) {
    //         if (n > 0 && n <= nums.length) {
    //             visited[n] = true;
    //         }
    //     }

    //     for (int i = 1; i <= nums.length; i++) {
    //         if (!visited[i]) {
    //             return i;
    //         }
    //     }

    //     return nums.length + 1;
    // }
}
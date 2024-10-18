class Solution {
    public int countMaxOrSubsets(int[] nums) {
        

        // first we calculate the maxBitwiseOr
        int maxBitwiseOr = 0;
        // We need count array as in recusrive function, if we just send an integer count, it will be passed by value and wont update this count but its own local copy.
        // Arrays on the other hand are passed by reference so the recursive function will update the original array
        int[] count = new int[1];

        // Now we calculate the maxBitwiseOr which is the OR of all the elements.
        for (int i = 0; i < nums.length; i++) {
            maxBitwiseOr = maxBitwiseOr | nums[i];
        }
        System.out.println(maxBitwiseOr);

        // call the dfs method again and again starting from 0th index
        dfs(nums, 0, 0, maxBitwiseOr, count);
        
        // return the count
        return count[0];
    }


    public static void dfs(int[] nums, int index, int currOr, int maxOr, int[] count) {
        // If the currentOr is equal to the maxOr, increment the count
        if (currOr == maxOr) {
            count[0]++;
        }
        
        // With each index we will get teh subset to get all the subsets of the array
        for (int i = index; i < nums.length; i++) {
            // Calculate dfs with currOr = currOR | present indexed element
            dfs(nums, i + 1, currOr | nums[i], maxOr, count);
        }

    }
}
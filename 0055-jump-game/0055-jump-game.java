class Solution {

    public boolean canJump(int[] nums) {
        int size = nums.length;

        // MaxIndex we can reach is 0 as that is the starting point.
        int maxIndex = 0;

        // if the size of the array is 1 then we are already at the destination
        // hence true
        if (size == 1) {
            return true;
        }
        
        // if the size is not 1 and the initial index value is 0, we cannot
        // jump any further.
        // so return false.
        if (nums[0] == 0) {
            return false;
        }

        // Now iterate throught the array
        // till before the last one, till then we would know
        // if we can reach or not.
        for (int i = 0; i < size - 1; i++) {
            

            // if we are at a index in the loop which is beyond our
            // maxIndex, it means we cannot even come here.
            // so return false.
            if (i > maxIndex) {
                return false;
            }

            // Now the max would be either the maxIndex as of now or 
            // number of steps + current index.
            maxIndex = Math.max(maxIndex, i + nums[i]); 

        }
        
        // If the maxIndex is equal or above the last index, it means we can reach there.
        if (maxIndex >= (size - 1)) {
            return true;
        }

        // Return false as this case will only come if we cannot reach the last index.
        return false;
    }
}
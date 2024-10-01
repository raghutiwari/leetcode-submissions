class Solution {
    public int findMin(int[] nums) {
        

        // left pointer
        int left = 0;
        // right pointer
        int right = nums.length - 1;

        // To keep the answer
        int ans = Integer.MAX_VALUE;

        // We do binary search
        while (left <= right) {
            int mid = left + (right - left)/ 2;

            // if the array is sorted already, then we put the min of
            // already computed ans and left indexed as min.
            // Also break out coz you got the minimum for this array
            if (nums[left] <= nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;
            }


            // If the left part is already sorted, then get the minimum from that subpart and eliminate it (go to the right part, as your work in the left part is done)
            if (nums[left] <= nums[mid]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1;                
            } else {
                // Same for the right part
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            
            }

        }

        return ans;
        
    }
}
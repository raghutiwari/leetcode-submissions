class Solution {
    public int findDuplicate(int[] nums) {

        // We use a slow and fast pointer approach
        // Keep moving the pointers
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // now the distance travelled by fast would be 2a and by slow would be a
        // so to find the point where the cycle starts, we need to start fast from beginning of the array.
        fast = nums[0];

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        } 

        return fast;
        
    }
}
class Solution {
    public boolean increasingTriplet(int[] nums) {

        // We initialise smallest and secondSmallest numbers
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // if the current number is smaller than small, we assign that
            if (nums[i] <= small) {
                small = nums[i];
            } else if (nums[i] <= secondSmall) {
                // if the current number is smaller than secondSmall but greater than small (since it fails the if condition and thats why came here), we assign the secondSmall number as current number
                secondSmall = nums[i];
            } else {
                // In case the numbe is bigger than small, bigger than secondSmall, then we know we have found our triplet.
                return true;
            }
        }

        return false;
        
    }
}
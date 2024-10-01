class Solution {

    /**
    Four cases can occur:
    Case 1: All +ve, maxProduct is product of all elements
    Case 2: Even -ves, maxProduct is product of all elements
    Case 3: Odd -ves, maxProduct is max product of all elemenets with one less -ve
    Case 4: Contains Zero, then we calculate max on the left side of 0 and max on the right side of 0.
    
     */
    public int maxProduct(int[] nums) {

        // Initialise maxProduct as minimum
        int maxProduct = Integer.MIN_VALUE;

        // Intiliase prefix and suffix as 1 as they will be required to help us
        // calculate product.
        int prefix = 1;
        int suffix = 1;

        // Iterate through the complete array
        for (int i = 0; i < nums.length; i++) {
            // Whenever we encounter 0, prefix and suffix will become 1.
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            
            // Prefix will be product starting from the beginning of array
            prefix *= nums[i];
            // Suffix will be product starting from the end of array.
            suffix *= nums[nums.length - i - 1];

            // Max Product will be either MaxProduct yet
            // OR max of prefix and suffix.
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));

        }

        return maxProduct;
    }
}
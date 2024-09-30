class Solution {
    /**
        The intution is to calculat the product of left side of each number with one pass.
        And then calculate the product of right side of each number with one pass.
        // Combine those products to calculate the result for each number.
     */
    public int[] productExceptSelf(int[] nums) {
        
        // Since there is no number on the left side of the 0th index, so keep as 1
        // to help in multiplication
        int left = 1;
        // Since there is no number on the right side of the nums.length -1th,
        // so keep as 1 to help in multiplication.
        int right = 1;

        // Result array to send back the result
        int[] result = new int[nums.length];

        // Initialise as 1 for each element.
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }

        // Now calculate the left product for each element.
        for (int i = 0; i < nums.length; i++) {
            // we multiply with whatever left product is calculated till now.
            result[i] *= left;
            // we add the number in multiplication of left for the next index.
            left *= nums[i];

        }

        // Do the same things as above to get the right side numbers product.
        for (int i = nums.length - 1; i >=0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        // return result
        return result;


        /**
            Naive Approach using Division.
         */
        // int product = 1;
        // int zeroCount = 0;
        // int[] result = new int[nums.length];

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         product *= nums[i];
        //     } else {
        //         zeroCount++;
        //     }
        // }

        // if (zeroCount >= 2) {
        //     product = 0;
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         result[i] = product;
        //     } else {
        //         if (zeroCount != 0) {
        //             result[i] = 0;
        //         } else {
        //             result[i] = product / nums[i];
        //         }
        //     }

        // }

        // return result;
        
    }
}
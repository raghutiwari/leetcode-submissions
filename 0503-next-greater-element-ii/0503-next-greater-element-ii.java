class Solution {
    public int[] nextGreaterElements(int[] nums) {

        // Stack which we will use to keep track of NGE
        Stack<Integer> s = new Stack<>();

        // Result array to store the corresponding NGE
        int[] result = new int[nums.length];

        // We will double the array (hypothetically) and start with the 
        // the last element in the doubled array
        for (int i = (nums.length * 2) - 1; i >= 0; i--) {
            
            // Will find the real index by moduling it.
            int index = i % nums.length;

            // As long as the stack is not empty and the number
            // is greater than or equal to the top of stack
            // This will make our stack monotonic in nature
            while (!s.isEmpty() && s.peek() <= nums[index]) {
                    s.pop();
            }

            // now if we are within the range of our actual array
            // we will update the NGE
            if (i < nums.length) {
                if (!s.isEmpty()) {
                    result[index] = s.peek();
                } else {
                    result[index] = -1;
                }
            }

            s.push(nums[index]);

        }

        return result;

        
    }
}
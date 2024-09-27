class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // Map to store the <number, its nge>. This is useful to return the result
        // for particular elements
        Map<Integer, Integer> map = new HashMap<>();

        // Stack to get the nge
        Stack<Integer> s = new Stack<>();

        // We start from the last of the array as we need to find
        // the nge element.
        for (int i = nums2.length - 1; i >= 0; i--) {
            
            // Iterate over the array until we find a element greater than the nums2[i] and keep popping as they wont contribute to the answer.
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }

            // if the stack is empty at this point, it means
            // there was no element greater than the current indexed element
            // so we put -1.
            if (s.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                // else we add it in the map
                map.put(nums2[i], s.peek());
            }

            s.push(nums2[i]);
            

        }

        // to store the final result
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            // check in map to get the nge for the particular nums1[i]
            result[i] = map.get(nums1[i]);
        }

        return result;


    }
}
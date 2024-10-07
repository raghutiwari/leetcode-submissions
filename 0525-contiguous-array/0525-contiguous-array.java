class Solution {
    /**
    We consider 0 as -1 while calculating prefixSum.

    The idea is to calculate prefixSum at each index and check if the same prefixSum
    was encountered previously. If yes, then the subarray after the previousIndex and currentIndex contains the equal numbers of 0s and 1s as the 0s will cancel the 1s.
     */
    public int findMaxLength(int[] nums) {
        // Initialise a map where key will be the prefixSum and value will be the index for which the prefixSum is calculated.
        Map<Integer, Integer> map = new HashMap<>();

        // to keep track of prefixSum at each index
        int prefixSum = 0;
        // this will keep track of maxLength of subArray with equal 1s and 0s
        int maxLength = 0;

        // Since right now, before starting our sum is 0 as we have encountered anyIndex, we keep the value as -1 (this will be useful if the whole array contains equal number of 1s and 0s)
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                prefixSum++;
            } else {
                prefixSum--;
            }


            if (map.containsKey(prefixSum)) {
                int previousIndex = map.get(prefixSum);
                // i - previousIndex will capture the subarray since we previously had
                // the same prefixSum
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
        
    }
}
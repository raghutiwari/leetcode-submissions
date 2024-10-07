class Solution {
    public int subarraySum(int[] nums, int k) {

        // Map to store (prefixSum, number of times that prefixSum is encountered)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Number of subArrays with sum = k
        int count = 0;
        int prefixSum = 0;
        // Since right now before starting, the prefixSum is 0, so we put the count as 1
        map.put(0, 1);

        // Now, the idea is to find the subarray with sum = k by capturing the prefixSum which is equal to prefixSum of current Index - k.

        for (int i = 0; i < nums.length; i++) {
            
            prefixSum += nums[i];
            int rem = prefixSum - k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
   
        }
        return count;
        
    }
}
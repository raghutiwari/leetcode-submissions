class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int ival = nums[i];

            if (ival > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + ival;

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    sums.add(Arrays.asList(ival, nums[left], nums[right]));
                    left++;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }

        }
        return sums;
    }

    // METHOD: Using inner loop concept

    // public List<List<Integer>> threeSum(int[] nums) {

    //     Map<Integer, Integer> map = new HashMap<>();

    //     List<List<Integer>> result = new ArrayList<>();

    //     for (int i = 0; i < nums.length - 1; i++) {
    //         int target = 0 - nums[i];
    //         for (int j = i + 1; j < nums.length; j++) {

    //             if (map.containsKey(target - nums[j])) {
    //                 List<Integer> subResult = new ArrayList<>();
    //                 subResult.add(nums[i]);
    //                 subResult.add(map.get(target - nums[j]));
    //                 subResult.add(target - nums[j]);
    //                 result.add(subResult);
    //             } else {
    //                 map.put(target - nums[j], nums[j]);
    //             }


    //         }
    //     }

    //     return result;
    // }
}
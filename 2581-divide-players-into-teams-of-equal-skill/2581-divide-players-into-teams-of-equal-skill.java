class Solution {

    public long dividePlayers(int[] skill) {
        // Sort the array as that would be helpful to get the pairs with same sum
        Arrays.sort(skill);


        // Using two pointer approach to create a pair with input[left] and input[right]
        int left = 0;
        int right = skill.length - 1;
        // RequiredSum which should be what for each pair.
        int requiredSum = skill[left] + skill[right];
        // Result which we want to give back
        long chemistrySum = 0;

        while (left <= right) {
            if (skill[left] + skill[right] != requiredSum) {
                return -1;
            }
            chemistrySum += (long) skill[left] * skill[right];
            left++;
            right--;
        }

        return chemistrySum;
        
    }
}
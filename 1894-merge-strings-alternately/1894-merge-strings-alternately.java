class Solution {
    public String mergeAlternately(String word1, String word2) {

        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        char[] result = new char[word1Arr.length + word2Arr.length];

        int left = 0;
        int right = 0;
        int index = 0;

        while (left < word1Arr.length && right < word2Arr.length) {
            
            result[index] = word1Arr[left];
            left++;
            index++;
            result[index] = word2Arr[right];
            right++;
            index++;
        }

        System.out.println("index " + index);
        System.out.println("left " + left);

        while (left < word1Arr.length) {
            result[index] = word1Arr[left];
            left++;
            index++;
        }

        while (right < word2Arr.length) {
            result[index] = word2Arr[right];
            right++;
            index++;
        }

    return new String(result);
        
    }
}
class Solution {
    // T: O(N^2), S: O(N)
    public int minExtraChar(String s, String[] dictionary) {
    
        int n = s.length();
        // Create a set to contains all the elements of dictionary
        // This will be used to check if the word is present as substring in the main string.
        Set<String> set = new HashSet<>();
        for(String word: dictionary) {
            set.add(word);
        }
        
        // Initialise a DP table. here dp[i] will represents the minimum number of extra characters in the substring s[0:i]
        int[] dp = new int[s.length() + 1];

        // first index means 0 length of s so initialise as 0.
        dp[0] = 0;

        // Initialise the rest as Maximum as we need to find the minimum
        // at each index.
        for (int i = 1; i < s.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Now, lets start with checking s[0, i]
        for (int i = 1; i <= s.length(); i++) {

                // if we don't find the substring in s[0,i],
                // it means the s[i] is an extra character so
                // we will just add it to the minimum of s[0, i - 1]
                // this is done when we have not found a valid word at dp[i]
                dp[i] = dp[i - 1] + 1;

                // Now, lets start with forming substring from all the characters from j to i and see if any of them is in the set.
                for(int j = 0; j < i; j++) {
                    if ( set.contains(s.substring(j, i))) {
                        // dp[i] = if there was no valid word found till dp[i]
                        // dp[j] = the minimum extra characters required,
                        // before we encounterd a valid word.
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }

        }

    // return the nth element of dp[n + 1]
    return dp[n];
        
    }
}
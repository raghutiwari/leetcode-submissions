class Solution {

    public boolean isPowerOfTwo(int n) {

        // if n == 1 then it is 2^0
        if (n == 1) {
            return true;
        }

        // If n == 0, then it is not a power of two as lowest is one.
        // if n == MIN_VALUE, we know it is not a power of two as 2^-31 - 1
        if (n == 0 || n == Integer.MIN_VALUE) return false;

        // we do a Bitwise & between n and n -1 and compare with 0.
        // Why?
        // if n is indeed power of 2, then the number before that, would have
        // all the bits as 1 where as n would have all the bits as 0 except
        // for bit n -1
        // eg 8 = 1000 and 7 = 0111;
        return (n & (n - 1)) == 0;


        
    }
}
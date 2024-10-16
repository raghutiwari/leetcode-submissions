class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        // Using a PQ since we always will try with the most frequent character available and maintaing the constraint of having atmost 2 same charaters in a row
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));

        StringBuilder result = new StringBuilder();

        // We will only have elements in the PQ if the character count which can be used to build the string is greater than 0
        while (!pq.isEmpty()) {

            // We get the character pair with most frequencey
            Pair curr = pq.poll();
            
            // If the length of the generated string as of now is greater than 2
            // and if the last two characters are the same
            // then we need to check for the next most frequent character
            if (result.length() >= 2 && result.charAt(result.length() - 1) == curr.c && result.charAt(result.length() - 2) == curr.c) {
                
                // if no other character present which can be used then break.
                if (pq.isEmpty()) {
                    break;
                }

                // We get the next most frequent character
                Pair next = pq.poll();
                // We append it to the string
                result.append(next.c);
                // We decrease the count as it has been used
                next.count--;
                // if the count is greater than 0, we add it back to PQ as it still can be used
                if (next.count > 0) {
                    pq.offer(next);
                }

            } else {
                // Else we just add the curr pair as that is the most frequent one and we still hold the constraint.
                result.append(curr.c);
                curr.count--;
            }

            // if more characters left, we add it back to the PQ
            if (curr.count > 0) {
                pq.offer(curr);
            }

        }
        
        return result.toString();
        
    }

    class Pair {
        char c;
        int count;

        public Pair (char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}


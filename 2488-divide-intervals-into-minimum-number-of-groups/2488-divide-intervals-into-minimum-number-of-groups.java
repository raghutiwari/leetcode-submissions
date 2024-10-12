class Solution {
    public int minGroups(int[][] intervals) {
        
        // Sort the arrays based on the starting interval, this will help us while iterating
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // PriorityQuue to compare the starting point of the next interval in the array to check if it can exists in any group
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval: intervals) {
            // if the priorityQueue is nonEmpty and the top of priorityQueue is less than the starting of start interval
            // it means it can be added to that group hence we first take the privous end interval out
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }

        return pq.size();
        

    }
}
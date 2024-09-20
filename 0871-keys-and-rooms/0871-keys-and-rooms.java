class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        // if there are no rooms, then we have no room to visit hence default is 0.
        if (rooms.size() == 0) {
            return true;
        }

        // create a boolean array to mark the rooms as visited.
        boolean[] visited = new boolean[rooms.size()];

        // create a queue to do a BFS.
        Queue<Integer> q = new LinkedList<>();
        // add the first room as we can visit that by default.
        q.add(0);

        // Now we perform a BFS untill the queue is not empty
        // we have not traversed the adjacency list
        while (!q.isEmpty()) {
            
            // get the first element of the queue (which is nothing but an index)
            int index = q.poll();

            // if this was already visited, we continue;
            if (visited[index]) {
                continue;
            }

            // We need to add all the keys present in that index (door)
            // This means we are going to add all the adjacent nodes to the queue
            for (int key: rooms.get(index)) {
                q.add(key);
            }
            // We mark the index (room) as visited
            visited[index] = true;

        }

        // Loop through the visited array and see if any index was not visisted
        // If yes, it means we have not visited all the rooms.
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        // In case we have visited all the rooms, the flow will come here
        // hence return true.
        return true;        
    }
}
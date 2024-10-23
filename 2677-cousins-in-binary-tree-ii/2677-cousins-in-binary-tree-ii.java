/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        // Double BFS Traversal

        // 1. Level Traversal
        // List to store level wise sum
        List<Integer> levels = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // the size will define we pop the nodes at a single level;
            int size = q.size();
            // before checking on the level, the levelSum will be 0
            int levelSum = 0;
            while(size-- > 0) {
                TreeNode curr = q.poll();
                levelSum += curr.val;
                // add the children in the queue.
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            // After getting all the sums, push the level sum into list
            levels.add(levelSum);
        }

        // Now we have the levelSums for all the levels, traverse a second time
        // to replace all nodes with cousin sums
        // Replace first level with zero because no cousins
        root.val = 0;
        // currLevel will be 1 which after root node since we dont want to calculate for root node
        int currLevel = 1;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0){
                TreeNode curr = q.poll();
                // Using the level sums we can get each children's cousins sum
                // by subtracting from the whole sum themselves and their siblings
                if (curr.left != null && curr.right != null) {
                    curr.left.val = levels.get(currLevel) - curr.left.val - curr.right.val;
                    curr.right.val = curr.left.val;
                } else if (curr.left != null && curr.right == null) {
                    curr.left.val = levels.get(currLevel) - curr.left.val;
                } else if (curr.left == null && curr.right != null) {
                    curr.right.val = levels.get(currLevel) - curr.right.val;
                }
                // Don't forget to push the left and right children if they exist
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            // Append level index
            currLevel++;
        }

        return root;
        
    }
}
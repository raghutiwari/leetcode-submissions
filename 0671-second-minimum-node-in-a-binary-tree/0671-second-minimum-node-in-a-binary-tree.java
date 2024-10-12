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
    public int findSecondMinimumValue(TreeNode root) {
        // Set to keep the traversal values and as the parent is the minimum of the child values
        // We are not interested in duplicates
        Set<Integer> set = new HashSet<>();

        // do an inorder traversal and then keep it in a set (to avoid duplicate values)
        inOrder(root, set);
        // Convert the set to a list (as accessing from a set requires an iterator)
        List<Integer> traversal = new ArrayList<>(set);
        // Sort the list
        Collections.sort(traversal);
        // if the size is 1 or smaller, we return -1 as we cannot get the second smallest
        if (traversal.size() <= 1) {
            return -1;
        } else {
            // else we return the 1st index (after 0th) to get the second smallest element,
            return traversal.get(1);
        }
        
    }

    public static void inOrder(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        inOrder(root.left, set);
        set.add(root.val);
        inOrder(root.right, set);
    }
}
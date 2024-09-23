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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // if both the nodes are null, the tree is same
        if (p == null && q == null) {
            return true;
        }

        // if any of them is null but not the other one,
        // then the tree is not same.
        if (p == null || q == null) {
            return false;
        }

        // if the value is not equal,
        // the tree is not same.
        if (p.val != q.val) {
            return false;
        }

        // now we recursively call with left child and right child.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}
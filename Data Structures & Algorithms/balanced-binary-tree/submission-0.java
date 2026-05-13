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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } 
        dfs(root);
        return res;   

    }

    public int dfs(TreeNode root) {
        if (root == null || res == false) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(right - left) > 1) {
            res = false;
            return 0;
        }
        return 1 + Math.max(left, right);
        
    }
}

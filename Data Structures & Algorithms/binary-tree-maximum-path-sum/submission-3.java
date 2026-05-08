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
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        int curr = root.val;
        res = Math.max(res, curr + left + right);
        return curr + Math.max(left, right); 
    }

    public int res = Integer.MIN_VALUE;

    public void recordMaxSum(int curr, int left, int right) {
        if (left >=0 && right >= 0) {
            res = Math.max(res, curr + left + right);
        } else {
            res = Math.max(res, curr + Math.max(left, right));
        }
    }
}

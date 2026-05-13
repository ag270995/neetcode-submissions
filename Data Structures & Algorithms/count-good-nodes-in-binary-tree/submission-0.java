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
    int count = 0;
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        goodNodes(root, max);
        return count;

    }

    public void goodNodes(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (val >= max) {
            max = val;
            count++;
        }

        goodNodes(root.left, max);
        goodNodes(root.right, max);
         
    }
}

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
    int res = -1;
    int index = 0;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        check(root, k);
        return res;
    }

    public void check(TreeNode root, int k) {
        if (root == null || found) {
            return;
        }
        check(root.left, k);
        int val = root.val;
        index++;
        if (index == k) {
            res = val;
            found = true;
            return;
        }
        if (!found) {
            check(root.right, k);
        }
    }
}

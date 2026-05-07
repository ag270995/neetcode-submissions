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
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lcaHelper(root, p, q);
        return res;
    }

    public void lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            lcaHelper(root, q, p);
            return;
        }
        if (root == null) {
            return;
        }
        int val = root.val;
        if (p.val <= val && q.val >= val) {
            res = root;
        } 
        
        if (q.val < val) {
            lcaHelper(root.left, p, q);
        } else if (p.val > val) {
            lcaHelper(root.right, p, q);
        }
     
    }
}

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

public class Codec {

    public static String N = "N";
    public static String S = ",";
    // Encodes a tree to a single string.
    public class Index {
        int index;
        public Index(int index) {
            this.index = index;
        }
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(N).append(S);
            return;
        }
        sb.append(root.val).append(S);
        preorder(root.left, sb);
        preorder(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(S);
        return deserialize(nodes, new Index(0));
    }

    public TreeNode deserialize(String[] nodes, Index index) {
        String val = nodes[index.index++];
        if (val.equals(N)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(nodes, index);        
        root.right = deserialize(nodes, index);        
        return root;
    }
}

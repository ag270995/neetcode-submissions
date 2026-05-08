public class Codec {

    private static final String SEP = ",";
    private static final String NULL = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(SEP);
        Index index = new Index(0);
        return build(arr, index);
    }

    private TreeNode build(String[] arr, Index index) {
        if (index.index >= arr.length) {
            return null;
        }

        String val = arr[index.index++];

        if (val.equals(NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = build(arr, index);
        root.right = build(arr, index);

        return root;
    }

    private static class Index {
        int index;

        Index(int index) {
            this.index = index;
        }
    }
}
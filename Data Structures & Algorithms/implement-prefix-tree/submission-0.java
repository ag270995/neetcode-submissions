class PrefixTree {

  public class TreeNode {
    boolean word;
    Map<Character, TreeNode> children;
    public TreeNode() {
      this.children = new HashMap();
      this.word = false;
    }
  }
    TreeNode root;

    public PrefixTree() {
      root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;
        for (char c : word.toCharArray()) {
          Map<Character, TreeNode> children = curr.children;
          if (!children.containsKey(c)) {
            children.put(c, new TreeNode());
          }
          curr = children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
      TreeNode curr = root;
        for (char c : word.toCharArray()) {
          Map<Character, TreeNode> children = curr.children;
          if (!children.containsKey(c)) {
            return false;
          }
          curr = children.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String word) {

      TreeNode curr = root;
        for (char c : word.toCharArray()) {
          Map<Character, TreeNode> children = curr.children;
          if (!children.containsKey(c)) {
            return false;
          }
          curr = children.get(c);
        }
        return true;

    }
}

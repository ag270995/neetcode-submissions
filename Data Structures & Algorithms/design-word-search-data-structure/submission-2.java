class WordDictionary {

    public class TreeNode {
        Map<Character, TreeNode> children;
        boolean word;
        public TreeNode() {
            children = new HashMap<>();
            word = false;
        }
    }

    TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
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
        
        return search(word, 0, root);
    }


    public boolean search(String word, int i, TreeNode root) {
        int n = word.length();
        Map<Character, TreeNode> children = root.children;
        if (i == n ) {  
            if (!root.word) {
                return false;
            } 
            return true;
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (TreeNode child : children.values()) {
                if (search(word, i + 1, child)) {
                    return true;
                }
            }
        } else if (children.containsKey(c)){
            return search(word, i + 1, children.get(c));
        }

        return false;
    }
}

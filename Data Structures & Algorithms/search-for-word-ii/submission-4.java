class Solution {
    public class TreeNode {
        Map<Character, TreeNode> children;
        String word;
        public TreeNode() {
            this.children = new HashMap<>();
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TreeNode root = new TreeNode();
        for (String word : words) {
            addWord(word, root);
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, root, i, j, visited);
            }
        }
        return new ArrayList<>(res);
    }

    Set<String> res = new HashSet<>();
    int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0,-1}, {0, 1}};
    
    public void dfs(char[][] board, TreeNode root, int row, int col, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        char ch = board[row][col];
        Map<Character, TreeNode> children = root.children;
        if (!children.containsKey(ch)) {
            return;
        }
        if (children.get(ch).word != null) {
            res.add(children.get(ch).word);
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            dfs(board, children.get(ch), i, j, visited);
        }
        visited[row][col] = false;

    }

    public void addWord(String word, TreeNode root) {
        TreeNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TreeNode());
            }
            curr = curr.children.get(c);
        }
        curr.word = word;
    }
}

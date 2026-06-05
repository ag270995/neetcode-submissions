class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.add(beginWord);
        Map<String, Set<String>> graph = buildGraph(wordSet);
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                visited.add(word);

                if (word.equals(endWord)) {
                    return count;
                }
                Set<String> children = graph.get(word);
                if (children == null) {
                    continue;
                }
                for (String child : children) {
                    if (visited.contains(child)) {
                        continue;
                    }
                    queue.offer(child);
                }

            }
            count++;

        }
        return 0;
    }

    static Map<String, Set<String>> buildGraph(Set<String> wordSet) {

        Map<String, Set<String>> graph = new HashMap<>();

        for (String word : wordSet) {
            graph.putIfAbsent(word, new HashSet<>());
        }

        for (String word : wordSet) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < 26; i++) {
                char change = (char)('a' + i);
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    chars[j] = change;
                    String child = new String(chars);
                    if (wordSet.contains(child) && !child.equals(word)) {
                        graph.get(word).add(child);
                    }
                    chars[j] = original;
                }

            }

        }

        return graph;


    }


}
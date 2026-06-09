class Solution {
    public static String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Add all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Build graph from adjacent words
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            int j = 0;
            while (j < prev.length() && j < curr.length()) {
                char c1 = prev.charAt(j);
                char c2 = curr.charAt(j);

                if (c1 != c2) {
                    // c1 should come before c2
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }

                j++;
            }

            // Invalid prefix case: "abc" before "ab"
            if (j == curr.length() && prev.length() > curr.length()) {
                return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);

            for (char nei : graph.get(curr)) {
                indegree.put(nei, indegree.get(nei) - 1);

                if (indegree.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }

        // Cycle detected
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}
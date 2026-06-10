class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> in = new HashMap<>();
        int n = words.length;
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                in.put(c, 0);
                graph.put(c, new HashSet<>());
            }
        }

        for (int i = 1; i < n; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int j = 0;
            while (j < prev.length() && j < curr.length()) {
                if (prev.charAt(j) != curr.charAt(j)) {
                    
                    if (!graph.get(prev.charAt(j)).contains(curr.charAt(j))) {
                        graph.get(prev.charAt(j)).add(curr.charAt(j));
                        in.put(curr.charAt(j), in.get(curr.charAt(j)) + 1);
                    }
                    break;
                }
                j++;
            }
            if (j == curr.length() && j < prev.length()) {
                return "";
            }
        } 
        Queue<Character> queue = new LinkedList<>();
        for (Character c : in.keySet()) {
            if (in.get(c) == 0) {
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char child : graph.get(c)) {
                in.put(child, in.get(child) - 1);
                if (in.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }
        if (sb.length() != in.size()) {
            return "";
        }

        return sb.toString();
      
    }
}
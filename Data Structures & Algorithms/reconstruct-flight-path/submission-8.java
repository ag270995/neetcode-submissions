class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            map.computeIfAbsent(src, k -> new PriorityQueue<String>()).add(dst);
        }
        List<String> list = new ArrayList<>();
        dfs(map, list, "JFK");
        Collections.reverse(list);
        return list;
    }

    void dfs(Map<String, PriorityQueue<String>> map, List<String> list, String node) {
        PriorityQueue<String> pq = map.get(node);
        while (pq != null && !pq.isEmpty()) {
            dfs(map, list, pq.poll());
        }
        list.add(node);
    }
}

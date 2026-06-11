class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            map.computeIfAbsent(src, k -> new PriorityQueue<String>()).add(dst);
        }
        LinkedList<String> list = new LinkedList<>();
        dfs(map, list, "JFK");
        return list;
    }

    void dfs(Map<String, PriorityQueue<String>> map, LinkedList<String> list, String node) {
        PriorityQueue<String> pq = map.get(node);
        while (pq != null && !pq.isEmpty()) {
            dfs(map, list, pq.poll());
        }
        list.addFirst(node);
    }
}

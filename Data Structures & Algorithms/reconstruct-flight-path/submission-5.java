class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> (new PriorityQueue<>())).offer(ticket.get(1));
        }
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", map, res);
        return res;
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> pq = map.get(node);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, res);
        }
        res.addFirst(node);
    }
}
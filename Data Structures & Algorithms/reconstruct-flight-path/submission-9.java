class Solution {
    Map<String, PriorityQueue<String>> adj;
    List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        String start = "JFK";
        int n = tickets.size();

        adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        res = new ArrayList<>();
        
        dfs(start, n);
        Collections.reverse(res);

        return res;   
    }

    private void dfs (String cur, int n) {
        PriorityQueue<String> pq = adj.get(cur);

        while (pq != null && !pq.isEmpty()) {
            String dst = pq.poll();
            dfs(dst, n);
        }

        res.add(cur);
    }
}

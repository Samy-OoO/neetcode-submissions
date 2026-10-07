class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        String start = "JFK";

        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String src = stack.peek();
            PriorityQueue<String> pq = adj.get(src);

            if (pq != null && !pq.isEmpty()) {
                stack.push(pq.poll());
            } else {
                res.add(stack.pop());
            }
        }

        Collections.reverse(res);
        return res;
    }
}

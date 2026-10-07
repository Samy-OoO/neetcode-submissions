class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        String start = "JFK";
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
            adj.computeIfAbsent(ticket.get(1), k -> new ArrayList<>());
        }

        for (Map.Entry<String, List<String>> entry : adj.entrySet()) {
            entry.getValue().sort(Comparator.reverseOrder());
        }

        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String src = stack.peek();

            if (!adj.get(src).isEmpty()) {
                String dst = adj.get(src).removeLast();
                stack.push(dst);
            } else {
                res.add(stack.pop());
            }
        }

        Collections.reverse(res);
        return res;
    }
}

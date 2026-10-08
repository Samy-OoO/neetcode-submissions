class Solution {
    List<char[]> edges = new ArrayList<>();
    Map<Character, List<Character>> adj = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();

    public String foreignDictionary(String[] words) {

        for (int i = 0; i < words.length; i++) {
            addVertices(words[i]);
            if (i+1 >= words.length) continue;
            if (!dfs(words[i], words[i+1], 0)) return "";
        }
        
        for (char[] chArr : edges) {
            adj.get(chArr[0]).add(chArr[1]);
            indegree.put(chArr[1], indegree.get(chArr[1]) + 1);
        }

        Queue<Character> q = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) q.offer(entry.getKey());
        }

        List<String> res = new ArrayList<>();
        int fin = 0;
        while (!q.isEmpty()) {
            char node = q.poll();
            res.add(String.valueOf(node));
            fin++;
            if (adj.get(node) != null) {
                for (Character nei : adj.get(node)) {
                    indegree.put(nei, indegree.get(nei) - 1);
                    if (indegree.get(nei) == 0) q.offer(nei);
                }
            }
        }
        if (fin != adj.size()) return "";

        return String.join("", res);
    }

    private boolean dfs(String w1, String w2, int i) {
        if (w1.length() == i || w2.length() == i) {
            if (w2.length() < w1.length()) return false;
            else return true;
        }
        
        char l1 = w1.charAt(i), l2 = w2.charAt(i);
        if (l1 != l2) {
            edges.add(new char[]{l1, l2});
            return true;
        }
        return dfs(w1, w2, i+1);
    }

    private void addVertices(String word){
        for (char ch : word.toCharArray()) {
            adj.computeIfAbsent(ch, k -> new ArrayList<>());
            indegree.putIfAbsent(ch, 0);
        }
    }
}
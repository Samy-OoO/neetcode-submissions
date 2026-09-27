class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> townsPpl = new HashMap<>();

        for (int[] t : trust) {
            townsPpl.computeIfAbsent(t[0], k -> new LinkedList<>());
            townsPpl.get(t[0]).add(t[1]);
        }

        if (townsPpl.size() == n-1){
            for (int i = 1; i <= n; i++) {
                if (!townsPpl.containsKey(i) && townsPpl.get(trust[0][0]).contains(i)) return i;
            }
        }

        return -1;
    }
}
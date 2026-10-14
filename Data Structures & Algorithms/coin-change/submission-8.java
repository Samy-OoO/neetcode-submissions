class Solution {
    public int coinChange(int[] coins, int amount) {
        boolean[] vis = new boolean[amount];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == amount) return cur[1];
            if (vis[cur[0]]) continue;
            vis[cur[0]] = true;

            for (int coin : coins) {
                if (cur[0] + coin <= amount) q.offer(new int[]{cur[0]+coin, cur[1]+1});
            }
        }
        return -1;
    }
}

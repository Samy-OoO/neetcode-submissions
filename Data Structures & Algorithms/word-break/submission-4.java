class Solution {
    private int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return dfs(0, s, wordDict);
    }

    private boolean dfs(int i, String s, List<String> wordDict) {
        if (i >= s.length()) return true;
        if (dp[i] != -1) return dp[i] == 1;

        boolean res = false;
        for (String w : wordDict) {
            if ((i + w.length()) > s.length()) continue;
            if (s.substring(i, i + w.length()).equals(w)) {
                res = res || dfs(i + w.length(), s, wordDict);
            }
        }

        dp[i] = res ? 1 : 0;
        return dp[i] == 1;
    }
}

class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp, -1);     
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i >= s.length()) return 1;
        if (dp[i] != -1) return dp[i];

        char c = s.charAt(i);
        if (c == '0') return 0;
        int twoDig = i+1 < s.length() ? Integer.parseInt("" + c + s.charAt(i+1)) : -1;

        if (twoDig > 0 && twoDig <= 26) return dp[i] = dfs(s, i+1) + dfs(s, i+2);
        return dp[i] = dfs(s, i+1);
    }
}

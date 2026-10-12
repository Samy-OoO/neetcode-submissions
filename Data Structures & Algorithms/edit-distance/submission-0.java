class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        // Deletions: word1 to ""
        for (int i=0; i <= m; i++) {
            dp[i][0] = i;
        }
        // Insertions: "" to word2
        for (int j=0; j <= n; j++) {
            dp[0][j] = j;
        }

        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1; // Match or Replacement

                dp[i][j] = Math.min(
                    dp[i-1][j-1] + cost, // Match or Replacement
                    Math.min(
                        dp[i][j-1] + 1,  // Deletion (directly left of it)
                        dp[i-1][j] + 1   // Insertion (directly above it)
                    )
                );
            }
        }

        return dp[m][n];

    }
}

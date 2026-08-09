class Solution {
    private int[][] dp;
    private int[] prefix;
    
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + piles[i];
        }
        
        dp = new int[n][n + 1];
        return dfs(0, 1, n);
    }
    
    private int dfs(int i, int m, int n) {
        if (i + 2 * m >= n) {
            return prefix[n] - prefix[i];
        }
        if (dp[i][m] != 0) {
            return dp[i][m];
        }
        
        int maxStones = 0;
        for (int x = 1; x <= 2 * m; x++) {
            int remaining = prefix[n] - prefix[i];
            int opponent = dfs(i + x, Math.max(m, x), n);
            maxStones = Math.max(maxStones, remaining - opponent);
        }
        
        dp[i][m] = maxStones;
        return maxStones;
    }
}
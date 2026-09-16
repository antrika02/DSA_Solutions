class Solution {
   static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        return (int) nCr(n + k - 1, 2 * k);
    }

    private long nCr(int n, int r) {
        long[][] dp = new long[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, r); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        return dp[n][r];  
    }
}
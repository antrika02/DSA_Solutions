class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i],
                        dp[i - j] + costs[i - 1] + j * j);
                }
            }
        }

        return dp[n];
    }
}
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int best = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int c = 0;

                    for (int r = 0; r < d; r++) {
                        int l = i + r;
                        int h = i + r + ((len - 1 - r) / d) * d;

                        while (l < h) {
                            if (s.charAt(l) != s.charAt(h))
                                c++;
                            l += d;
                            h -= d;
                        }
                    }

                    best = Math.min(best, c);
                }

                cost[i][i + len - 1] = best;
            }
        }

        int inf = 1000000;
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp)
            java.util.Arrays.fill(row, inf);

        dp[0][0] = 0;

        for (int t = 1; t <= k; t++) {
            for (int i = 2 * t; i <= n; i++) {
                for (int j = 2 * (t - 1); j <= i - 2; j++) {
                    dp[t][i] = Math.min(dp[t][i],
                        dp[t - 1][j] + cost[j][i - 1]);
                }
            }
        }

        return dp[k][n];
    }
}
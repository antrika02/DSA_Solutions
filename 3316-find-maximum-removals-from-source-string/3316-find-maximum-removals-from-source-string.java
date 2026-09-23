class Solution {
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int n = source.length();
        boolean[] can = new boolean[n];

        for (int x : targetIndices) {
            can[x] = true;
        }
        int m = pattern.length();
        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            char c = source.charAt(i);
            for (int j = m; j >= 1; j--) {
                if (c == pattern.charAt(j - 1)) {
                    int add = can[i] ? 0 : 0;

                    if (dp[j - 1] != -1 || j == 1) {
                        int v = dp[j - 1];

                        if (can[i]) {
                            dp[j] = Math.max(dp[j], v);
                        } else {
                            dp[j] = Math.max(dp[j], v);
                        }
                    }
                }
            }
        }
        int[] f = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            f[i] = n + 1;
        }
        f[0] = 0;

        for (int i = 0; i < n; i++) {
            char c = source.charAt(i);

            for (int j = m; j >= 1; j--) {
                if (c == pattern.charAt(j - 1)) {
                    int cost = can[i] ? 1 : 0;
                    f[j] = Math.min(f[j], f[j - 1] + cost);
                }
            }
        }

        int need = f[m];

        return targetIndices.length - need;
    }
}
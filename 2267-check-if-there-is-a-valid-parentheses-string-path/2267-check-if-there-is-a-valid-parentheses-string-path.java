class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n];

        dp[0][0][1] = grid[0][0] == '(';

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int b = 0; b < m + n; b++) {
                    if (!dp[i][j][b]) {
                        continue;
                    }

                    if (i + 1 < m) {
                        int nb = grid[i + 1][j] == '(' ? b + 1 : b - 1;

                        if (nb >= 0) {
                            dp[i + 1][j][nb] = true;
                        }
                    }

                    if (j + 1 < n) {
                        int nb = grid[i][j + 1] == '(' ? b + 1 : b - 1;

                        if (nb >= 0) {
                            dp[i][j + 1][nb] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}
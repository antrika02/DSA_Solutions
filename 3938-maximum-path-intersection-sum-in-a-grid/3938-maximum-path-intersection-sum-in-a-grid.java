class Solution {
    public int maxScore(int[][] grid) {
        int m = grid.length;

        int n = grid[0].length;

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < m - 1; i++) {

            for (int j = 1; j < n - 1; j++) {

                ans = Math.max(ans, grid[i][j]);

            }

        }

        // Check all rows.

        for (int i = 0; i < m; i++) {

            int end = grid[i][0];

            for (int j = 1; j < n; j++) {

                int cur = grid[i][j];
                int next = Math.max(cur, end + cur);
                ans = Math.max(ans, end + cur);

                end = next;

            }

        }

        for (int j = 0; j < n; j++) {

            int end = grid[0][j];

            for (int i = 1; i < m; i++) {

                int cur = grid[i][j];

                int next = Math.max(cur, end + cur);
                ans = Math.max(ans, end + cur);

                end = next;

            }

        }

        return ans;
    }
}
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j, m, n)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean dfs(int[][] g, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;

        if (g[i][j] == 1)
            return true;

        g[i][j] = 1;

        boolean a = dfs(g, i - 1, j, m, n);
        boolean b = dfs(g, i + 1, j, m, n);
        boolean c = dfs(g, i, j - 1, m, n);
        boolean d = dfs(g, i, j + 1, m, n);

        return a && b && c && d;
    }
}
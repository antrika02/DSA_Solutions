class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;

        int n = grid[0].length;

        int t = m * n;

        k %= t;

        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int x = i * n + j;

                int y = (x + k) % t;

                a[y / n][y % n] = grid[i][j];

            }

        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            List<Integer> r = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                r.add(a[i][j]);

            }

            ans.add(r);

        }

        return ans;
    }
}
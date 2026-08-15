class Solution {
    public int countLocalMaximums(int[][] matrix) {
         int n = matrix.length, m = matrix[0].length;

        int ans = 0;

        for (int x = 1; x <= 200; x++) {

            int[][] pre = new int[n + 1][m + 1];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {

                    int v = matrix[i][j] > x ? 1 : 0;

                    pre[i + 1][j + 1] = v + pre[i][j + 1]

                            + pre[i + 1][j] - pre[i][j];

                }

            }

            for (int r = 0; r < n; r++) {

                for (int c = 0; c < m; c++) {

                    if (matrix[r][c] != x) continue;

                    int r1 = Math.max(0, r - x);

                    int r2 = Math.min(n - 1, r + x);

                    int c1 = Math.max(0, c - x);

                    int c2 = Math.min(m - 1, c + x);

                    int cnt = pre[r2 + 1][c2 + 1]

                            - pre[r1][c2 + 1]

                            - pre[r2 + 1][c1]

                            + pre[r1][c1];
                    if (r - x >= 0 && c - x >= 0 && matrix[r - x][c - x] > x)

                        cnt--;

                    if (r - x >= 0 && c + x < m && matrix[r - x][c + x] > x)

                        cnt--;

                    if (r + x < n && c - x >= 0 && matrix[r + x][c - x] > x)

                        cnt--;

                    if (r + x < n && c + x < m && matrix[r + x][c + x] > x)

                        cnt--;

                    if (cnt == 0)

                        ans++;

                }

            }

        }

        return ans;
    }
}
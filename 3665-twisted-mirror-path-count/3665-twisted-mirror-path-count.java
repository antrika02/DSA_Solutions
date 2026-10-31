class Solution {
    int LEFT = 0; 
    int UP = 1;   
    int MOD = 1_000_000_007;
    int m, n;

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][][] t = new int[m + 1][n + 1][2];

        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                for (int cameFrom = 0; cameFrom < 2; cameFrom++) {
                    if (row == m - 1 && col == n - 1) {
                        t[row][col][cameFrom] = 1;
                        continue;
                    }
                    if (grid[row][col] == 1) {
                        if (cameFrom == LEFT)
                            t[row][col][cameFrom] = t[row + 1][col][UP];  
                        else
                            t[row][col][cameFrom] = t[row][col + 1][LEFT]; 
                        continue;
                    }
                    long total = 0;
                    total += t[row][col + 1][LEFT]; 
                    total += t[row + 1][col][UP];  

                    t[row][col][cameFrom] = (int) (total % MOD);
                }
            }
        }

        return t[0][0][LEFT]; 
    }
}
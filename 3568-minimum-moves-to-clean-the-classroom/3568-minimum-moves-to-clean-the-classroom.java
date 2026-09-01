class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        char[][] g = new char[m][];
        for (int i = 0; i < m; i++) g[i] = classroom[i].toCharArray();
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) Arrays.fill(row, -1);
        int total = 0, sr = 0, sc = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 'L') litterId[i][j] = total++;
                else if (g[i][j] == 'S') { sr = i; sc = j; }
            }

        int full = 1 << total;         
        if (total == 0) return 0;
        int[][][] best = new int[m][n][full];
        for (int[][] a : best) for (int[] b : a) Arrays.fill(b, -1);

        best[sr][sc][0] = energy;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc, 0, energy}); 

        int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
        int steps = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            steps++;                           
            for (int s = 0; s < sz; s++) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (g[nr][nc] == 'X') continue;

                    int ne = cur[3] - 1;      
                    if (ne < 0) continue;     

                    int nmask = cur[2];
                    if (litterId[nr][nc] >= 0) nmask |= (1 << litterId[nr][nc]);
                    if (g[nr][nc] == 'R') ne = energy;  

                    if (nmask == full - 1) return steps; 

                    if (best[nr][nc][nmask] >= ne) continue; 
                    best[nr][nc][nmask] = ne;
                    q.add(new int[]{nr, nc, nmask, ne});
                }
            }
        }
        return -1;
    }
}
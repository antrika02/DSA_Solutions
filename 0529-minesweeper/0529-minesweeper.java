class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];

        int c = click[1];

        if (board[r][c] == 'M') {

            board[r][c] = 'X';

            return board;

        }

        int m = board.length;

        int n = board[0].length;

        dfs(board, r, c, m, n);

        return board;

    }

    private void dfs(char[][] b, int r, int c, int m, int n) {

        if (r < 0 || r >= m || c < 0 || c >= n || b[r][c] != 'E') {

            return;

        }

        int cnt = 0;

        for (int dr = -1; dr <= 1; dr++) {

            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0) {

                    continue;

                }

                int nr = r + dr;

                int nc = c + dc;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n

                        && b[nr][nc] == 'M') {

                    cnt++;

                }

            }

        }

        if (cnt > 0) {

            b[r][c] = (char) ('0' + cnt);

            return;

        }

        b[r][c] = 'B';

        for (int dr = -1; dr <= 1; dr++) {

            for (int dc = -1; dc <= 1; dc++) {

                if (dr != 0 || dc != 0) {

                    dfs(b, r + dr, c + dc, m, n);

                }

            }

        }
    }
}
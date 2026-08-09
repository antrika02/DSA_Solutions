class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {

            g[i] = new ArrayList<>();

        }

        for (int i = 0; i < n - 1; i++) {

            g[i].add(i + 1);

            g[i + 1].add(i);

        }

        x--;

        y--;

        if (x != y) {

            g[x].add(y);

            g[y].add(x);

        }

        int[] ans = new int[n];

        for (int s = 0; s < n; s++) {

            int[] d = new int[n];

            Arrays.fill(d, -1);

            Queue<Integer> q = new LinkedList<>();

            q.offer(s);

            d[s] = 0;

            while (!q.isEmpty()) {

                int u = q.poll();

                for (int v : g[u]) {

                    if (d[v] == -1) {

                        d[v] = d[u] + 1;

                        q.offer(v);

                    }

                }

            }

            for (int i = 0; i < n; i++) {

                if (d[i] > 0) {

                    ans[d[i] - 1]++;

                }

            }

        }

        return ans;
    }
}
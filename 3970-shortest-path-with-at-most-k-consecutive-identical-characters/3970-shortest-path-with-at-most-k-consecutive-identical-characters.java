import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges)
            g[e[0]].add(new int[]{e[1], e[2]});

        int[][] d = new int[n][k + 1];
        for (int[] a : d) Arrays.fill(a, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        d[0][1] = 0;
        pq.offer(new int[]{0, 1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], cnt = cur[1], cost = cur[2];

            if (cost != d[u][cnt]) continue;

            if (u == n - 1) return cost;

            for (int[] e : g[u]) {
                int v = e[0], w = e[1];

                int nc = labels.charAt(u) == labels.charAt(v)
                    ? cnt + 1 : 1;

                if (nc > k) continue;

                int nd = cost + w;

                if (nd < d[v][nc]) {
                    d[v][nc] = nd;
                    pq.offer(new int[]{v, nc, nd});
                }
            }
        }

        return -1;
    }
}
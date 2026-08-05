class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
         List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            g.add(new ArrayList<>());

        }

        for (int[] e : invocations) {

            g.get(e[0]).add(e[1]);

        }

        boolean[] vis = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();

        q.offer(k);

        vis[k] = true;

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int v : g.get(u)) {

                if (!vis[v]) {

                    vis[v] = true;

                    q.offer(v);

                }

            }

        }

        for (int[] e : invocations) {

            int u = e[0];

            int v = e[1];

            if (!vis[u] && vis[v]) {

                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {

                    ans.add(i);

                }

                return ans;

            }

        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                ans.add(i);

            }

        }

        return ans;
    }
}
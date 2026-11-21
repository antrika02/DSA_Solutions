class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] g = new ArrayList[n];

        List<Integer>[] ng = new ArrayList[n];

        for (int i = 0; i < n; i++) {

            g[i] = new ArrayList<>();

            ng[i] = new ArrayList<>();

        }

        for (int i = 1; i < n; i++)

            g[parent[i]].add(i);

        int[] np = parent.clone();

        int[] last = new int[26];

        Arrays.fill(last, -1);

        int[] prev = new int[n];

        Arrays.fill(prev, -1);

        Stack<Integer> st = new Stack<>();

        Stack<Integer> state = new Stack<>();

        st.push(0);

        state.push(0);

        while (!st.isEmpty()) {

            int u = st.peek();

            int c = s.charAt(u) - 'a';

            if (state.peek() == 0) {

                prev[u] = last[c];

                if (last[c] != -1)

                    np[u] = last[c];

                last[c] = u;

                state.pop();

                state.push(1);

                for (int i = g[u].size() - 1; i >= 0; i--) {

                    st.push(g[u].get(i));

                    state.push(0);

                }

            } else {

                last[c] = prev[u];

                st.pop();

                state.pop();

            }

        }

        for (int i = 1; i < n; i++)

            ng[np[i]].add(i);

        int[] ans = new int[n];

        int[] order = new int[n];

        int idx = 0;

        st.push(0);

        while (!st.isEmpty()) {

            int u = st.pop();

            order[idx++] = u;

            for (int v : ng[u])

                st.push(v);

        }

        for (int i = n - 1; i >= 0; i--) {

            int u = order[i];

            ans[u]++;

            if (np[u] != -1)

                ans[np[u]] += ans[u];

        }

        return ans;
    }
}
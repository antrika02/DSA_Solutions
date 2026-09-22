class Solution {
    int n, k;
    long[] tree;
    int[][] cnt;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new long[4 * n];
        cnt = new int[4 * n][k];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q][0];
            int val = queries[q][1];
            int st = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, idx, val % k);

            ans[q] = query(1, 0, n - 1, st, n - 1, x, 1)[x];
        }

        return ans;
    }
    void build(int node, int l, int r, int[] a) {
        if (l == r) {
            int v = a[l] % k;
            tree[node] = v;
            cnt[node][v] = 1;
            return;
        }

        int m = l + (r - l) / 2;

        build(node * 2, l, m, a);
        build(node * 2 + 1, m + 1, r, a);

        merge(node, node * 2, node * 2 + 1);
    }

    void merge(int node, int left, int right) {
        long lp = tree[left];

        tree[node] = (lp * tree[right]) % k;

        for (int r = 0; r < k; r++) {
            cnt[node][r] = cnt[left][r];
        }
        for (int r = 0; r < k; r++) {
            int nr = (int) ((lp * r) % k);
            cnt[node][nr] += cnt[right][r];
        }
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            for (int i = 0; i < k; i++) {
                cnt[node][i] = 0;
            }
            cnt[node][val] = 1;
            return;
        }

        int m = l + (r - l) / 2;

        if (idx <= m) {
            update(node * 2, l, m, idx, val);
        } else {
            update(node * 2 + 1, m + 1, r, idx, val);
        }

        merge(node, node * 2, node * 2 + 1);
    }
    int[] query(int node, int l, int r, int ql, int qr, int x, int dummy) {
        if (ql <= l && r <= qr) {
            int[] res = new int[k + 1];

            for (int i = 0; i < k; i++) {
                res[i] = cnt[node][i];
            }

            res[k] = (int) tree[node];
            return res;
        }

        int m = l + (r - l) / 2;

        if (qr <= m) {
            return query(node * 2, l, m, ql, qr, x, dummy);
        }

        if (ql > m) {
            return query(node * 2 + 1, m + 1, r, ql, qr, x, dummy);
        }

        int[] a = query(node * 2, l, m, ql, qr, x, dummy);
        int[] b = query(node * 2 + 1, m + 1, r, ql, qr, x, dummy);

        int[] res = new int[k + 1];
        for (int i = 0; i < k; i++) {
            res[i] += a[i];
        }
        int lp = a[k];

        for (int i = 0; i < k; i++) {
            int nr = (lp * i) % k;
            res[nr] += b[i];
        }

        res[k] = (lp * b[k]) % k;

        return res;
    }
}
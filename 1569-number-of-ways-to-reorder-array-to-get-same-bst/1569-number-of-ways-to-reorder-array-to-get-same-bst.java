class Solution {
    static final int MOD = 1000000007;
    long[][] c = new long[1001][1001];

    public int numOfWays(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
            }
        }

        List<Integer> a = new ArrayList<>();
        for (int x : nums) a.add(x);

        return (int) ((dfs(a) - 1 + MOD) % MOD);
    }

    long dfs(List<Integer> a) {
        int n = a.size();
        if (n <= 2) return 1;

        int r = a.get(0);
        List<Integer> l = new ArrayList<>();
        List<Integer> rt = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (a.get(i) < r) l.add(a.get(i));
            else rt.add(a.get(i));
        }

        long x = dfs(l);
        long y = dfs(rt);

        return c[n - 1][l.size()] * x % MOD * y % MOD;
    }
}
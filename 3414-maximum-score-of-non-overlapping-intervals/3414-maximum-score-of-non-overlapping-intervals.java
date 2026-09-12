import java.util.*;

class Solution {
    static class State {
        long sum;
        int[] a;

        State(long sum, int[] a) {
            this.sum = sum;
            this.a = a;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] in = new int[n][4];
        for (int i = 0; i < n; i++) {
            in[i][0] = intervals.get(i).get(0);
            in[i][1] = intervals.get(i).get(1);
            in[i][2] = intervals.get(i).get(2);
            in[i][3] = i;
        }

        Arrays.sort(in, (x, y) -> {
            if (x[1] != y[1])
                return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });

        long[] ends = new long[n];
        for (int i = 0; i < n; i++)
            ends[i] = in[i][1];

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++)
                dp[i][k] = new State(0, new int[0]);
        }

        for (int i = 1; i <= n; i++) {
            int[] cur = in[i - 1];

            // Number of intervals ending strictly before cur[0]
            int p = lowerBound(ends, i - 1, cur[0]);

            for (int k = 1; k <= 4; k++) {
                State skip = dp[i - 1][k];

                State prev = dp[p][k - 1];
                int[] b = Arrays.copyOf(prev.a, prev.a.length + 1);
                b[b.length - 1] = cur[3];
                Arrays.sort(b);

                State take = new State(prev.sum + cur[2], b);

                dp[i][k] = better(skip, take);
            }
        }

        return dp[n][4].a;
    }

    private int lowerBound(long[] a, int n, long x) {
        int l = 0, r = n;

        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    private State better(State x, State y) {
        if (x.sum != y.sum)
            return x.sum > y.sum ? x : y;

        return compare(x.a, y.a) <= 0 ? x : y;
    }

    private int compare(int[] a, int[] b) {
        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                return Integer.compare(a[i], b[i]);
        }

        return Integer.compare(a.length, b.length);
    }
}
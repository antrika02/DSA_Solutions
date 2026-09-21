class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];

        long[] dp = new long[k];

        for (int num : nums) {

            long[] ndp = new long[k];

            int v = num % k;
            ndp[v]++;
            for (int r = 0; r < k; r++) {

                if (dp[r] > 0) {

                    int nr = (r * v) % k;

                    ndp[nr] += dp[r];

                }

            }

            dp = ndp;
            for (int r = 0; r < k; r++) {

                ans[r] += dp[r];

            }

        }

        return ans;
    }
}
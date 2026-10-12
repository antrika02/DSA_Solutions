class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = 1000000007;

        int[] cnt = new int[32];

        for (int x : nums) {

            for (int b = 0; b < 32; b++) {

                if ((x & (1 << b)) != 0) cnt[b]++;

            }

        }

        long ans = 0;

        for (int i = 0; i < k; i++) {

            long x = 0;

            for (int b = 0; b < 32; b++) {

                if (cnt[b] > 0) {

                    x |= (1L << b);

                    cnt[b]--;

                }

            }

            ans = (ans + x * x % mod) % mod;

        }

        return (int) ans;
    }
}
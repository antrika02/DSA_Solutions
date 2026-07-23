class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        long[] cnt = new long[101];

        for (int x : arr) {
            cnt[x]++;
        }

        long ans = 0;

        for (int i = 0; i <= 100; i++) {
            if (cnt[i] == 0) continue;

            for (int j = i; j <= 100; j++) {
                if (cnt[j] == 0) continue;

                int k = target - i - j;

                if (k < j || k > 100) continue;
                if (cnt[k] == 0) continue;

                if (i == j && j == k) {
                    ans += cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
                } else if (i == j) {
                    ans += (cnt[i] * (cnt[i] - 1) / 2) * cnt[k];
                } else if (j == k) {
                    ans += cnt[i] * (cnt[j] * (cnt[j] - 1) / 2);
                } else {
                    ans += cnt[i] * cnt[j] * cnt[k];
                }

                ans %= MOD;
            }
        }

        return (int) ans;
    }
}
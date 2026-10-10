class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] a = new int[n];
        int mx = 0;

        for (int i = 0; i < n; i++) {
            a[i] = Math.abs(nums1[i] - nums2[i]);
            mx = Math.max(mx, a[i]);
        }

        long sum = 0;
        for (int x : a) sum += x;

        if (sum <= k) return 0;

        int l = 0, r = mx;

        while (l < r) {
            int m = (l + r) / 2;
            long need = 0;

            for (int x : a) {
                if (x > m) need += x - m;
            }

            if (need <= k) r = m;
            else l = m + 1;
        }

        int h = l;
        long rem = k;

        for (int i = 0; i < n; i++) {
            if (a[i] > h) {
                rem -= a[i] - h;
                a[i] = h;
            }
        }

        for (int i = 0; i < n && rem > 0; i++) {
            if (a[i] == h && h > 0) {
                a[i]--;
                rem--;
            }
        }

        long ans = 0;
        for (int x : a) ans += (long) x * x;

        return ans;
    }
}
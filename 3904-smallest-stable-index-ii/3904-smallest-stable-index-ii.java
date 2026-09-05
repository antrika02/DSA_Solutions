class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suf = new int[n];

        suf[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--)
            suf[i] = Math.min(suf[i + 1], nums[i]);

        int mx = nums[0];

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);

            if ((long)mx - suf[i] <= k)
                return i;
        }

        return -1;
    }
}
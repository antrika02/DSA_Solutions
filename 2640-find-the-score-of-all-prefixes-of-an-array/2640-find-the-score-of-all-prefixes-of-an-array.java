class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;

        long[] ans = new long[n];

        long sum = 0;

        int mx = 0;

        for (int i = 0; i < n; i++) {

            mx = Math.max(mx, nums[i]);

            sum += (long) nums[i] + mx;

            ans[i] = sum;

        }

        return ans;
    }
}
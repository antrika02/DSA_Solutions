class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;

        for (int x : nums)

            ones += x;

        if (ones == 0 || ones == nums.length)

            return 0;

        int cnt = 0, ans = Integer.MAX_VALUE;

        int n = nums.length;

        for (int i = 0; i < n + ones - 1; i++) {

            cnt += nums[i % n];

            if (i >= ones)

                cnt -= nums[(i - ones) % n];

            if (i >= ones - 1)

                ans = Math.min(ans, ones - cnt);

        }

        return ans;
    }
}
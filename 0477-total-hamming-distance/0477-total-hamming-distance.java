class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for (int b = 0; b < 31; b++) {

            int ones = 0;

            for (int x : nums) {

                if ((x & (1 << b)) != 0) {

                    ones++;

                }

            }

            int zeros = n - ones;

            ans += ones * zeros;

        }

        return ans;
    }
}
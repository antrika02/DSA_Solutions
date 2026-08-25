class Solution {
    public int minimumSwaps(int[] nums) {
       int n = nums.length;

        int z = 0;

        for (int x : nums) {

            if (x == 0) {

                z++;

            }

        }

        int ans = 0;

        for (int i = n - z; i < n; i++) {

            if (nums[i] != 0) {

                ans++;

            }

        }

        return ans;
    }
}
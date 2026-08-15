class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;

        int xor = 0;

        for (int x : nums)

            xor ^= x;

        if (xor != 0)

            return n;

        for (int x : nums) {

            if (x != 0)

                return n - 1;

        }

        return 0;
    }
}
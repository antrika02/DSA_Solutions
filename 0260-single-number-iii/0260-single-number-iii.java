class Solution {
    public int[] singleNumber(int[] nums) {

        int x = 0;

        for (int n : nums) {
            x ^= n;
        }

        int b = x & -x;

        int a = 0, c = 0;

        for (int n : nums) {
            if ((n & b) == 0) {
                a ^= n;
            } else {
                c ^= n;
            }
        }

        return new int[]{a, c};
    }
}
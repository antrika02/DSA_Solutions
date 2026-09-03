class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = Integer.MAX_VALUE;

        boolean odd = false;

        for (int x : nums1) {

            mn = Math.min(mn, x);

            if ((x & 1) == 1)

                odd = true;

        }

        return !odd || (mn & 1) == 1;
    }
}
class Solution {
    public long minArraySum(int[] nums, int k) {
         int n = nums.length;

        int[] quorlathin = nums;

        long[] best = new long[k];

        java.util.Arrays.fill(best, Long.MAX_VALUE / 4);

        best[0] = 0;

        long sum = 0;

        long dp = 0;

        for (int x : quorlathin) {

            sum += x;

            int r = (int)(sum % k);

            long keep = dp + x;

            long del = best[r];

            dp = Math.min(keep, del);

            best[r] = Math.min(best[r], dp);

        }

        return dp;
    }
}
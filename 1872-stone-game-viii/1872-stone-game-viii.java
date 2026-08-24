class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        long[] pre = new long[n];

        pre[0] = stones[0];

        for (int i = 1; i < n; i++) {

            pre[i] = pre[i - 1] + stones[i];

        }

        long best = pre[n - 1];
        for (int i = n - 2; i >= 1; i--) {

            best = Math.max(best, pre[i] - best);

        }

        return (int) best;
    }
}
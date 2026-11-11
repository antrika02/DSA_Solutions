class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long a = Math.min(cost1, costBoth);
        long b = Math.min(cost2, costBoth);

        long x = Math.min(need1, need2);

        long c1 = (long) x * costBoth
                + (long) (need1 - x) * cost1
                + (long) (need2 - x) * cost2;

        long c2 = (long) Math.max(need1, need2) * costBoth;

        long c3 = (long) need1 * cost1 + (long) need2 * cost2;

        return Math.min(c1, Math.min(c2, c3));
    }
}
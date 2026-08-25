class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);

        Arrays.sort(discounts);

        int n = prices.length;

        int m = discounts.length;

        int cnt = Math.min(n, m);

        double ans = 0;

        for (int i = 0; i < n - cnt; i++) {

            ans += prices[i];

        }

        for (int i = 0; i < cnt; i++) {

            int p = prices[n - cnt + i];

            int d = discounts[m - cnt + i];

            ans += (double) p * (100 - d) / 100.0;

        }

        return ans;
    }
}
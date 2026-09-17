class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int inf = n + 1;
        int ans = inf;
        int sum = 0, l = 0;
        int prev = inf;

        for (int r = 0; r < n; r++) {
            sum += arr[r];

            while (sum > target) {
                sum -= arr[l++];
            }

            if (sum == target) {
                int len = r - l + 1;

                if (l > 0 && best[l - 1] < inf)
                    ans = Math.min(ans, len + best[l - 1]);

                prev = Math.min(prev, len);
            }

            best[r] = prev;
        }

        return ans == inf ? -1 : ans;
    }
}
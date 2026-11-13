import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0, cost = 0;
        int j = n - 1;

        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i], cnt = 1;

            while (!dq.isEmpty() && dq.peekLast()[0] < x) {
                int[] p = dq.pollLast();
                cost += (long) (x - p[0]) * p[1];
                cnt += p[1];
            }

            dq.offerLast(new int[]{x, cnt});

            while (cost > k) {
                int[] p = dq.pollFirst();
                cost -= p[0] - nums[j];
                j--;

                if (p[1] > 1)
                    dq.offerFirst(new int[]{p[0], p[1] - 1});
            }

            ans += j - i + 1;
        }

        return ans;
    }
}
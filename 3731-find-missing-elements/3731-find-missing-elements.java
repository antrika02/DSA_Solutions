class Solution {
    public List<Integer> findMissingElements(int[] nums) {
         int mn = Integer.MAX_VALUE;

        int mx = Integer.MIN_VALUE;

        boolean[] vis = new boolean[101];

        for (int x : nums) {

            mn = Math.min(mn, x);

            mx = Math.max(mx, x);

            vis[x] = true;

        }

        List<Integer> ans = new ArrayList<>();

        for (int i = mn; i <= mx; i++) {

            if (!vis[i]) {

                ans.add(i);

            }

        }

        return ans;
    }
}
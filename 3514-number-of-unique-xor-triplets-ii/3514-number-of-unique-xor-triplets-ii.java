class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] present = new boolean[MAX];
        for (int x : nums) {
            present[x] = true;
        }

        boolean[] dp1 = new boolean[MAX];
        boolean[] dp2 = new boolean[MAX];
        boolean[] dp3 = new boolean[MAX];

        for (int v = 0; v < MAX; v++) {
            if (present[v]) {
                dp1[v] = true;
            }
        }

        for (int x = 0; x < MAX; x++) {
            if (!dp1[x]) continue;
            for (int v = 0; v < MAX; v++) {
                if (present[v]) {
                    dp2[x ^ v] = true;
                }
            }
        }

        for (int x = 0; x < MAX; x++) {
            if (!dp2[x]) continue;
            for (int v = 0; v < MAX; v++) {
                if (present[v]) {
                    dp3[x ^ v] = true;
                }
            }
        }

        int ans = 0;
        for (boolean b : dp3) {
            if (b) ans++;
        }

        return ans;
    }
}
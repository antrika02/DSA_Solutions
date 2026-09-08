class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sum = (long) n * (n + 1) / 2;
        
        if (Math.abs(target) > sum || ((sum - target) & 1) != 0)
            return new int[0];
        
        long need = (sum - target) / 2;
        boolean[] neg = new boolean[n + 1];
        for (int i = n; i >= 1; i--) {
            if (i <= need) {
                neg[i] = true;
                need -= i;
            }
        }
        
        int[] ans = new int[n];
        int k = 0;
        for (int i = n; i >= 1; i--) {
            if (neg[i])
                ans[k++] = -i;
        }
        for (int i = 1; i <= n; i++) {
            if (!neg[i])
                ans[k++] = i;
        }
        
        return ans;
    }
}
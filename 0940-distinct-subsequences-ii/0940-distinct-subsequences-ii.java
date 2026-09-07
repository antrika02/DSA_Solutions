class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        long[] dp = new long[26];
        
        for (char c : s.toCharArray()) {
            int x = c - 'a';
            long total = 1;
            
            for (long v : dp) {
                total = (total + v) % mod;
            }
            
            dp[x] = total;
        }
        
        long ans = 0;
        for (long v : dp) {
            ans = (ans + v) % mod;
        }
        
        return (int) ans;
    }
}
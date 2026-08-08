class Solution {
    public long numOfSubsequences(String s) {
        int n = s.length();

        long[] prefix = new long[n + 1];
        long[] suffix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                prefix[i + 1] = 1;
            }
            
            prefix[i + 1] += prefix[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'T') {
                suffix[i] = 1;
            }
            
            suffix[i] += suffix[i + 1];
        }

        long p1 = 0; 
        long p2 = 0; 
        long p3 = 0; 
        long maxi = 0; 

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'C') {
                p1 += (prefix[i + 1] + 1) * suffix[i];
                p2 += (suffix[i] + 1) * prefix[i + 1];
                p3 += prefix[i + 1] * suffix[i];
            }

            maxi = Math.max(maxi, prefix[i + 1] * suffix[i]);
        }

        p3 += maxi;

        return Math.max(p1, Math.max(p2, p3));
    }
}
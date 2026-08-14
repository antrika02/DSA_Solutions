class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < n; right++) {
            char rChar = s.charAt(right);
            freq[rChar - 'a']++;
            while (freq[rChar - 'a'] > 2) {
                char lChar = s.charAt(left);
                freq[lChar - 'a']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        int[] len = new int[n];

        for (int i = 0; i < n; i++) {
            int m = 0;
            for (char c : words[i].toCharArray()) {
                m |= (1 << (c - 'a'));
            }
            mask[i] = m;
            len[i] = words[i].length();
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, len[i] * len[j]);
                }
            }
        }

        return ans;
    }
}
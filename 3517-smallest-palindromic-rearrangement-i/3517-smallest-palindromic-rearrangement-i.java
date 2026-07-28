class Solution {
    public String smallestPalindrome(String s) {
        int[] f = new int[26];

        for (char c : s.toCharArray()) {

            f[c - 'a']++;

        }

        StringBuilder l = new StringBuilder();

        char mid = 0;

        for (int i = 0; i < 26; i++) {

            for (int j = 0; j < f[i] / 2; j++) {

                l.append((char) ('a' + i));

            }

            if ((f[i] & 1) == 1) {

                mid = (char) ('a' + i);

            }

        }

        StringBuilder ans = new StringBuilder();

        ans.append(l);

        if (mid != 0) {

            ans.append(mid);

        }

        ans.append(new StringBuilder(l).reverse());

        return ans.toString();
    }
}
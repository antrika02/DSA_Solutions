class Solution {
    public String smallestSubsequence(String s) {
        int[] f = new int[26];

        boolean[] v = new boolean[26];

        for (char c : s.toCharArray()) {

            f[c - 'a']++;

        }

        StringBuilder st = new StringBuilder();

        for (char c : s.toCharArray()) {

            int x = c - 'a';

            f[x]--;

            if (v[x]) continue;

            while (st.length() > 0) {

                char t = st.charAt(st.length() - 1);

                if (t > c && f[t - 'a'] > 0) {

                    v[t - 'a'] = false;

                    st.deleteCharAt(st.length() - 1);

                } else {

                    break;

                }

            }

            st.append(c);

            v[x] = true;

        }

        return st.toString();
    }
}
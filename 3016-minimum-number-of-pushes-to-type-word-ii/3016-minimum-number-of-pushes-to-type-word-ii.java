class Solution {
    public int minimumPushes(String word) {
        int[] f = new int[26];

        for (char c : word.toCharArray()) {

            f[c - 'a']++;

        }

        Integer[] a = new Integer[26];

        for (int i = 0; i < 26; i++) {

            a[i] = f[i];

        }

        Arrays.sort(a, Collections.reverseOrder());

        int ans = 0;

        for (int i = 0; i < 26; i++) {

            if (a[i] == 0) break;

            ans += a[i] * (i / 8 + 1);

        }

        return ans;
    }
}
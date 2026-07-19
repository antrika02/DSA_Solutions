class Solution {
    public String originalDigits(String s) {
         int[] c = new int[26];

        for (char ch : s.toCharArray()) {

            c[ch - 'a']++;

        }

        int[] d = new int[10];

        d[0] = c['z' - 'a'];

        d[2] = c['w' - 'a'];

        d[4] = c['u' - 'a'];

        d[6] = c['x' - 'a'];

        d[8] = c['g' - 'a'];

        d[3] = c['h' - 'a'] - d[8];

        d[5] = c['f' - 'a'] - d[4];

        d[7] = c['s' - 'a'] - d[6];

        d[1] = c['o' - 'a'] - d[0] - d[2] - d[4];

        d[9] = c['i' - 'a'] - d[5] - d[6] - d[8];

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i <= 9; i++) {

            while (d[i]-- > 0) {

                ans.append(i);

            }

        }

        return ans.toString();
    }
}
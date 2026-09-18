class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] l = new int[26];
        int[] r = new int[26];

        Arrays.fill(l, n);
        Arrays.fill(r, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            l[c] = Math.min(l[c], i);
            r[c] = i;
        }

        List<int[]> v = new ArrayList<>();
        for (int c = 0; c < 26; c++) {
            if (r[c] == -1) continue;

            int a = l[c];
            int b = r[c];
            boolean ok = true;

            for (int i = a; i <= b; i++) {
                int x = s.charAt(i) - 'a';

                if (l[x] < a) {
                    ok = false;
                    break;
                }

                b = Math.max(b, r[x]);
            }

            if (ok) {
                v.add(new int[]{a, b});
            }
        }
        v.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();
        int end = -1;

        for (int[] p : v) {
            if (p[0] > end) {
                ans.add(s.substring(p[0], p[1] + 1));
                end = p[1];
            }
        }

        return ans;
    }
}
class Solution {
    public int countRotations(String s, int k) {
        int n = s.length(), ans = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int j = 0; j < n - 1; j++) {
                if (s.charAt((i + j) % n) == s.charAt((i + j + 1) % n))
                    cnt++;
            }

            if (cnt == k) ans++;
        }

        return ans;
    }
}
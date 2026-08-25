class Solution {
    public int maximumGap(String skill, String station) {
         int n = skill.length();

        int m = station.length();
        int[] left = new int[n];

        int p = 0;

        for (int i = 0; i < n; i++) {

            while (station.charAt(p) != skill.charAt(i))

                p++;

            left[i] = p++;

        }
        int[] right = new int[n];

        p = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            while (station.charAt(p) != skill.charAt(i))

                p--;

            right[i] = p--;

        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {

            ans = Math.max(ans, right[i + 1] - left[i]);

        }

        return ans;
    }
}
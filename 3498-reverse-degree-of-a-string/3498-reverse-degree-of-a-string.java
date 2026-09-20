class Solution {
    public int reverseDegree(String s) {
         int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int v = 'z' - s.charAt(i) + 1;

            ans += v * (i + 1);

        }

        return ans;
    }
}
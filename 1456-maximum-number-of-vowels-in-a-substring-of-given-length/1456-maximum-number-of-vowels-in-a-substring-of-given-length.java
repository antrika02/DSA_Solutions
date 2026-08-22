class Solution {
    public int maxVowels(String s, int k) {
        int cnt = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if ("aeiou".indexOf(s.charAt(i)) >= 0)

                cnt++;

            if (i >= k && "aeiou".indexOf(s.charAt(i - k)) >= 0)

                cnt--;

            if (i >= k - 1)

                ans = Math.max(ans, cnt);

        }

        return ans;
    }
}
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int left = 0;

        int ones = 0;

        int bestLen = Integer.MAX_VALUE;

        String ans = "";

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == '1')

                ones++;

            while (ones > k) {

                if (s.charAt(left) == '1')

                    ones--;

                left++;

            }

            if (ones == k) {

                while (s.charAt(left) == '0')

                    left++;

                int len = right - left + 1;

                String cur = s.substring(left, right + 1);

                if (len < bestLen || (len == bestLen && cur.compareTo(ans) < 0)) {

                    bestLen = len;

                    ans = cur;

                }

            }

        }

        return ans;
    }
}
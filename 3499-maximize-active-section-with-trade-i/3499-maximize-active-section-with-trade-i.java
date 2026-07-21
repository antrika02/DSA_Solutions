class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";

        int n = t.length();

        int ones = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') ones++;

        }

        java.util.ArrayList<Character> tp = new java.util.ArrayList<>();

        java.util.ArrayList<Integer> len = new java.util.ArrayList<>();

        int i = 0;

        while (i < n) {

            char c = t.charAt(i);

            int j = i;

            while (j < n && t.charAt(j) == c) j++;

            tp.add(c);

            len.add(j - i);

            i = j;

        }

        int ans = ones;

        for (int k = 1; k + 1 < tp.size(); k++) {

            if (tp.get(k) == '1' && tp.get(k - 1) == '0' && tp.get(k + 1) == '0') {

                ans = Math.max(ans, ones + len.get(k - 1) + len.get(k + 1));

            }

        }

        return ans;
    }
}
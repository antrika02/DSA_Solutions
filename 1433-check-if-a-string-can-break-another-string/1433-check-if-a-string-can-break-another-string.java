class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] c1 = new int[26], c2 = new int[26];
        for (char c : s1.toCharArray()) c1[c - 'a']++;
        for (char c : s2.toCharArray()) c2[c - 'a']++;

        int sum1 = 0, sum2 = 0;
        boolean aWins = true, bWins = true;

        for (int i = 0; i < 26; i++) {
            sum1 += c1[i];
            sum2 += c2[i];
            if (sum1 > sum2) aWins = false;
            if (sum2 > sum1) bWins = false;
        }
        return aWins || bWins;
    }
}
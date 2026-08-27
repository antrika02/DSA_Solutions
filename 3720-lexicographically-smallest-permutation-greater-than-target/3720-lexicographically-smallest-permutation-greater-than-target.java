class Solution {
    public String lexGreaterPermutation(String s, String target) {
         int n = s.length();

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {

            count[ch - 'a']++;

        }

        char[] t = target.toCharArray();
        for (int i = n - 1; i >= 0; i--) {

            int[] remaining = count.clone();
            boolean possible = true;

            for (int j = 0; j < i; j++) {

                int c = t[j] - 'a';

                if (remaining[c] == 0) {

                    possible = false;

                    break;

                }

                remaining[c]--;

            }

            if (!possible) {

                continue;

            }
            int targetChar = t[i] - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (remaining[c] > 0) {

                    StringBuilder ans = new StringBuilder();
                    for (int j = 0; j < i; j++) {

                        ans.append(t[j]);

                    }
                    ans.append((char) ('a' + c));

                    remaining[c]--;
                    for (int x = 0; x < 26; x++) {

                        while (remaining[x] > 0) {

                            ans.append((char) ('a' + x));

                            remaining[x]--;

                        }

                    }

                    return ans.toString();

                }

            }

        }

        return "";
    }
}
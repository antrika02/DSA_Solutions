class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();

        int m = word2.length();
        int[] suffix = new int[n + 1];

        

        int j = m - 1;

        

        for (int i = n - 1; i >= 0; i--) {

            

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {

                j--;

            }

            

            suffix[i] = m - 1 - j;

        }

        

        List<Integer> ans = new ArrayList<>();

        

        int idx2 = 0;

        boolean usedMismatch = false;

        

        for (int i = 0; i < n && idx2 < m; i++) {

            

            char c1 = word1.charAt(i);

            char c2 = word2.charAt(idx2);
            if (c1 == c2) {

                ans.add(i);

                idx2++;

            }

            else if (!usedMismatch) {
                int remain = m - (idx2 + 1);
                if (suffix[i + 1] >= remain) {

                    usedMismatch = true;

                    ans.add(i);

                    idx2++;

                }

            }

        }

        

        if (idx2 != m) {

            return new int[0];

        }

        

        int[] res = new int[m];

        

        for (int i = 0; i < m; i++) {

            res[i] = ans.get(i);

        }

        

        return res;
    }
}
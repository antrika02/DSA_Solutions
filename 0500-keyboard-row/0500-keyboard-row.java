class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        List<String> ans = new ArrayList<>();

        for (String w : words) {

            String s = w.toLowerCase();

            int r = -1;

            boolean ok = true;

            for (int j = 0; j < rows.length; j++) {

                if (rows[j].indexOf(s.charAt(0)) >= 0) {

                    r = j;

                    break;

                }

            }

            for (int i = 1; i < s.length(); i++) {

                if (rows[r].indexOf(s.charAt(i)) < 0) {

                    ok = false;

                    break;

                }

            }

            if (ok) {

                ans.add(w);

            }

        }

        return ans.toArray(new String[0]);
    }
}
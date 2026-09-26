class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for (List<String> x : knowledge) {

            map.put(x.get(0), x.get(1));

        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) != '(') {

                ans.append(s.charAt(i));

                i++;

            } else {

                int j = i + 1;

                while (s.charAt(j) != ')') {

                    j++;

                }

                String key = s.substring(i + 1, j);

                if (map.containsKey(key)) {

                    ans.append(map.get(key));

                } else {

                    ans.append('?');

                }

                i = j + 1;

            }

        }

        return ans.toString();
    }
}
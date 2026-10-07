import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0)
                    left--;
                else
                    right++;
            }
        }

        dfs(s, 0, left, right, ans, seen);
        return ans;
    }

    private void dfs(String s, int pos, int left, int right,
                      List<String> ans, Set<String> seen) {
        if (left == 0 && right == 0) {
            if (valid(s) && seen.add(s))
                ans.add(s);
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (i > pos && s.charAt(i) == s.charAt(i - 1))
                continue;

            char c = s.charAt(i);

            if (right > 0 && c == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1),
                    i, left, right - 1, ans, seen);
            }

            if (left > 0 && c == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1),
                    i, left - 1, right, ans, seen);
            }
        }
    }

    private boolean valid(String s) {
        int bal = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                bal++;
            else if (c == ')') {
                bal--;
                if (bal < 0)
                    return false;
            }
        }

        return bal == 0;
    }
}
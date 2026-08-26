import java.util.*;

class Solution {
    Map<String, Integer> ids = new HashMap<>();
    Map<Integer, Integer> cnt = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    int id = 1;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        String key = node.val + "#" + l + "#" + r;

        int curId = ids.getOrDefault(key, id++);
        ids.putIfAbsent(key, curId);

        int count = cnt.getOrDefault(curId, 0) + 1;
        cnt.put(curId, count);

        if (count == 2)
            ans.add(node);

        return curId;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();

    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {

        dfs(root);

        ArrayList<Integer> list = new ArrayList<>();

        for (int k : map.keySet()) {

            if (map.get(k) == max) {

                list.add(k);

            }

        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {

            ans[i] = list.get(i);

        }

        return ans;

    }

    private int dfs(TreeNode node) {

        if (node == null) return 0;

        int sum = node.val + dfs(node.left) + dfs(node.right);

        int cnt = map.getOrDefault(sum, 0) + 1;

        map.put(sum, cnt);

        max = Math.max(max, cnt);

        return sum; 
    }
}
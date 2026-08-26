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
     HashMap<String, Integer> map = new HashMap<>();

    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        serialize(root);

        return result;

    }

    private String serialize(TreeNode node) {

        if (node == null) {

            return "#";

        }

        String left = serialize(node.left);

        String right = serialize(node.right);

        String key = node.val + "," + left + "," + right;

        int count = map.getOrDefault(key, 0);
        if (count == 1) {

            result.add(node);

        }

        map.put(key, count + 1);

        return key;  
    }
}
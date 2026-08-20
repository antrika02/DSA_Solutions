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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] part = new int[3];

        find(root, x, part);

        int left = part[0];

        int right = part[1];

        int parent = n - left - right - 1;

        int max = Math.max(parent, Math.max(left, right));

        return max > n / 2;

    }

    private int find(TreeNode root, int x, int[] part) {

        if (root == null) return 0;

        int l = find(root.left, x, part);

        int r = find(root.right, x, part);

        if (root.val == x) {

            part[0] = l;

            part[1] = r;

        }

        return l + r + 1;
    }
}
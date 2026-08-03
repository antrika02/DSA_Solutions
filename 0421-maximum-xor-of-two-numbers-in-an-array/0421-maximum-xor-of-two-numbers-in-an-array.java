class Solution {

    static class Node {
        Node[] ch = new Node[2];
    }

    public int findMaximumXOR(int[] nums) {

        Node root = new Node();

        for (int x : nums) {
            Node cur = root;

            for (int b = 31; b >= 0; b--) {
                int bit = (x >> b) & 1;

                if (cur.ch[bit] == null) {
                    cur.ch[bit] = new Node();
                }

                cur = cur.ch[bit];
            }
        }

        int ans = 0;

        for (int x : nums) {
            Node cur = root;
            int val = 0;

            for (int b = 31; b >= 0; b--) {
                int bit = (x >> b) & 1;
                int want = bit ^ 1;

                if (cur.ch[want] != null) {
                    val |= (1 << b);
                    cur = cur.ch[want];
                } else {
                    cur = cur.ch[bit];
                }
            }

            ans = Math.max(ans, val);
        }

        return ans;
    }
}
class Solution {
    static class Node {
        int pre = 0; 
        int suf = 0;
        int maxLen = 0;
        char leftChar = 0;
        char rightChar = 0;

        Node() {}
        Node(int pre, int suf, int maxLen, char leftChar, char rightChar) {
            this.pre = pre;
            this.suf = suf;
            this.maxLen = maxLen;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    int n;
    Node[] segTree; 

    Node merge(Node L, Node R, int leftLen, int rightLen) {
        Node res = new Node();

        res.leftChar  = L.leftChar;
        res.rightChar = R.rightChar;

        res.pre = L.pre;
        if (L.pre == leftLen && L.rightChar == R.leftChar) {
            res.pre = L.pre + R.pre;
        }

        res.suf = R.suf;
        if (R.suf == rightLen && L.rightChar == R.leftChar) {
            res.suf = R.suf + L.suf;
        }

        res.maxLen = Math.max(L.maxLen, R.maxLen);
        if (L.rightChar == R.leftChar) {
            res.maxLen = Math.max(res.maxLen, L.suf + R.pre);
        }

        return res;
    }

    void buildSegmentTree(int i, int l, int r, String s) {
        if (l == r) {
            segTree[i] = new Node(1, 1, 1, s.charAt(l), s.charAt(l));
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, s);
        buildSegmentTree(2 * i + 2, mid + 1, r, s);
        segTree[i] = merge(segTree[2 * i + 1], segTree[2 * i + 2], mid - l + 1, r - mid);
    }

    void update(int i, int l, int r, int pos, char ch) {
        if (l == r) { 
            segTree[i] = new Node(1, 1, 1, ch, ch);
            return;
        }
        int mid = l + (r - l) / 2;
        if (pos <= mid) {
            update(2 * i + 1, l, mid, pos, ch);
        } else {
            update(2 * i + 2, mid + 1, r, pos, ch);
        }
        segTree[i] = merge(segTree[2 * i + 1], segTree[2 * i + 2], mid - l + 1, r - mid);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        n = s.length();
        segTree = new Node[4 * n];

        buildSegmentTree(0, 0, n - 1, s);

        int k = queryIndices.length;

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int pos = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            update(0, 0, n - 1, pos, ch);

            result[i] = segTree[0].maxLen;
        }

        return result;
    }
}
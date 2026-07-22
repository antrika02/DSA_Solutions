import bisect
from typing import List


class ST:
    def __init__(self, pairs):
        self.n = len(pairs)
        self.st = [0] * (4 * self.n)
        if self.n:
            self.build(pairs, 1, 0, self.n - 1)

    def build(self, pairs, node, l, r):
        if l == r:
            self.st[node] = pairs[l]
            return self.st[node]

        mid = l + (r - l) // 2
        lc = self.build(pairs, node * 2, l, mid)
        rc = self.build(pairs, node * 2 + 1, mid + 1, r)
        self.st[node] = max(lc, rc)
        return self.st[node]

    def query(self, node, l, r, ql, qr):
        if self.n == 0 or ql > qr:
            return 0

        if l > qr or r < ql:
            return 0

        if ql <= l and r <= qr:
            return self.st[node]

        mid = l + (r - l) // 2
        lc = self.query(node * 2, l, mid, ql, qr)
        rc = self.query(node * 2 + 1, mid + 1, r, ql, qr)
        return max(lc, rc)


class Solution:
    def maxActiveSectionsAfterTrade(
        self, s: str, queries: List[List[int]]
    ) -> List[int]:

        n = len(s)
        ones = 0
        zeros = []

        i = 0
        while i < n:
            if s[i] == '0':
                j = i
                while j < n and s[j] == s[i]:
                    j += 1
                zeros.append((i, j - 1))  # [l, r]
                i = j
            else:
                ones += 1
                i += 1

        if len(zeros) < 2:
            return [ones] * len(queries)

        pairs = []
        for i in range(1, len(zeros)):
            l1, r1 = zeros[i - 1]
            l2, r2 = zeros[i]
            pairs.append((r1 - l1 + 1) + (r2 - l2 + 1))

        st = ST(pairs)

        starts = [block[0] for block in zeros]
        ends = [block[1] for block in zeros]

        res = []

        for l, r in queries:
            first = bisect.bisect_left(ends, l)
            last = bisect.bisect_right(starts, r) - 1

            if first >= last:
                res.append(ones)
                continue

            best = st.query(1, 0, st.n - 1, first + 1, last - 2)

            # touching left
            prev1 = min(zeros[first][1], r) - max(zeros[first][0], l) + 1
            next1 = min(zeros[first + 1][1], r) - max(zeros[first + 1][0], l) + 1
            best = max(best, prev1 + next1)

            # touching right
            prev1 = min(zeros[last - 1][1], r) - max(zeros[last - 1][0], l) + 1
            next1 = min(zeros[last][1], r) - max(zeros[last][0], l) + 1
            best = max(best, prev1 + next1)

            res.append(ones + best)

        return res
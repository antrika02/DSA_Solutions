class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0, j = 0;

        int n = series1.length;

        int m = series2.length;

        while (i < n || j < m) {

            int t;

            if (i == n) {

                t = series2[j][0];

            } else if (j == m) {

                t = series1[i][0];

            } else {

                t = Math.min(series1[i][0], series2[j][0]);

            }

            while (i < n && series1[i][0] < t)

                i++;

            while (j < m && series2[j][0] < t)

                j++;

            int v1 = (i < n) ? series1[i][1] : 0;

            int v2 = (j < m) ? series2[j][1] : 0;

            List<Integer> cur = new ArrayList<>();

            cur.add(t);

            cur.add(v1 + v2);

            ans.add(cur);

            if (i < n && series1[i][0] == t)

                i++;

            if (j < m && series2[j][0] == t)

                j++;

        }

        return ans;
    }
}
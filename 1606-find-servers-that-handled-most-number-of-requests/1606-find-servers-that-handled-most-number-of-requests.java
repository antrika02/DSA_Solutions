class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < k; i++) set.add(i);

        PriorityQueue<int[]> pq = new PriorityQueue<>(

            (a, b) -> Integer.compare(a[0], b[0])

        );

        int[] cnt = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            while (!pq.isEmpty() && pq.peek()[0] <= arrival[i]) {

                set.add(pq.poll()[1]);

            }

            if (set.isEmpty()) continue;

            int s = i % k;

            Integer id = set.ceiling(s);

            if (id == null) id = set.first();

            set.remove(id);

            cnt[id]++;

            pq.offer(new int[]{arrival[i] + load[i], id});

        }

        int max = 0;

        for (int x : cnt) max = Math.max(max, x);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            if (cnt[i] == max) ans.add(i);

        }

        return ans;
    }
}
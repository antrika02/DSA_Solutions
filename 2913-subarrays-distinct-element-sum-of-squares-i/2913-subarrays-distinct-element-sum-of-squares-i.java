class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), ans = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();

            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                ans += s.size() * s.size();
            }
        }

        return ans;
    }
}
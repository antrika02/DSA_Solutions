class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        long small = Arrays.stream(nums, 0, n / 2).asLongStream().sum();
        long large = Arrays.stream(nums, n / 2, n).asLongStream().sum();

        return large - small;
    }
}

class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int j = 0;

        int c = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {

                c = 0;

            }

            if (c < k) {

                nums[j++] = nums[i];

                c++;

            }

        }

        int[] ans = new int[j];

        System.arraycopy(nums, 0, ans, 0, j);

        return ans;
    }
}
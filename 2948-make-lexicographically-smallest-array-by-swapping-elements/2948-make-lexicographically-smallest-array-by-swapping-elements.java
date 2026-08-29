class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;

        // Store {value, original index}
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        java.util.Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int start = 0;

        while (start < n) {

            int end = start;

            // Find all values that belong to the same group.
            // If consecutive values differ by <= limit,
            // they can all be connected through swaps.
            while (end + 1 < n &&
                   (long) arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            // Get the original indices of this group.
            int size = end - start + 1;
            int[] indices = new int[size];

            for (int i = 0; i < size; i++) {
                indices[i] = arr[start + i][1];
            }

            // Sort indices so that the smallest values
            // are placed at the smallest indices.
            java.util.Arrays.sort(indices);

            // Values are already sorted because arr is sorted.
            for (int i = 0; i < size; i++) {
                nums[indices[i]] = arr[start + i][0];
            }

            start = end + 1;
        }

        return nums;
    }
}
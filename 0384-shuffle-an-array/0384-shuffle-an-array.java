class Solution {
    private int[] org;

    private Random r;

    public Solution(int[] nums) {

        org = nums.clone();

        r = new Random();

    }

    public int[] reset() {

        return org.clone();

    }

    public int[] shuffle() {

        int[] a = org.clone();

        for (int i = a.length - 1; i > 0; i--) {

            int j = r.nextInt(i + 1);

            int t = a[i];

            a[i] = a[j];

            a[j] = t;

        }

        return a;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
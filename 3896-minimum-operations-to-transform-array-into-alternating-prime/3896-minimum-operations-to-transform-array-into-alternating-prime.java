class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int max = 100000 + n + 5;

        boolean[] prime = new boolean[max];

        java.util.Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i * i < max; i++) {

            if (prime[i]) {

                for (int j = i * i; j < max; j += i)

                    prime[j] = false;

            }

        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int x = nums[i];

            if (i % 2 == 0) {

                while (!prime[x]) {

                    x++;

                    ans++;

                }

            } else {

                while (prime[x]) {

                    x++;

                    ans++;

                }

            }

        }

        return ans;
    }
}
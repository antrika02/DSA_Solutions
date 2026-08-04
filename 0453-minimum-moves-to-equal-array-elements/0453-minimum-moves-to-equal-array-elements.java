class Solution {
    public int minMoves(int[] nums) {
       int mn = nums[0];

        

        for (int x : nums) {

            if (x < mn) {

                mn = x;

            }

        }

        

        int ans = 0;

        

        for (int x : nums) {

            ans += x - mn;

        }

        

        return ans; 
    }
}
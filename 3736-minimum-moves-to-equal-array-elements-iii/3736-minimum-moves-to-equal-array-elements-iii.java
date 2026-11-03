class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int moves = 0;
        for(int n:nums){
            if(n>max) max = n;
        }
        for(int n:nums){
            moves += (max-n);
        }
        return moves;
    }
}
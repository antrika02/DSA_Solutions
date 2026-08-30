class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;

        for (int k = 0; k < n; k++) {
            if (nums[k] < nums[minIdx]) minIdx = k;
            if (nums[k] > nums[maxIdx]) maxIdx = k;
        }

        int i = Math.min(minIdx, maxIdx);  
        int j = Math.max(minIdx, maxIdx); 

        int bothFromFront = j + 1;      
        int bothFromBack  = n - i;       
        int frontAndBack  = (i + 1) + (n - j);

        return Math.min(bothFromFront, Math.min(bothFromBack, frontAndBack));
    }
}
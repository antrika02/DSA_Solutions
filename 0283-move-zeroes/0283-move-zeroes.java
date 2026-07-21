class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        // Brute approach



        int n = nums.length;
        for (int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if (nums[i]==nums[j]){
                    count++;
                }
            }
            if(count != 2){
                return nums[i];
            }
        }
       return -1; 
        //  int max = 0;
        // for(int i = 0; i< n; i++){
        //     max = Math.max(max, nums[i]);
        // }
        // int[] hash_array = new int[max+1];
        // for(int i = 0; i<n; i++){
        //     hash_array[nums[i]]++;
        // }
        // for(int i = 0; i<n; i++){
        //     if(hash_array[nums[i]] ==1){
        //         return nums[i];
        //     }
        // }
        // return -1;
    }
}
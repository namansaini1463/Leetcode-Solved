class Solution {
    public long minOperations(int[] nums) {
        int n = nums.length;

        long cost = 0;
        for(int i = 0; i < n-1; i++){
            if(nums[i+1] < nums[i]){
                cost += nums[i] - nums[i+1];
            }
        }

        return cost;
    }
}
class Solution {
    public int waysToSplitArray(int[] nums) {
        int numWaysToSplitArray = 0;
        // Calculating the sum of the `nums` array
        long sum = 0;
        for(int num : nums){
            sum += num;
        }

        long cummulativeLeftSum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            cummulativeLeftSum += nums[i];

            if(cummulativeLeftSum >= sum - cummulativeLeftSum) numWaysToSplitArray++;
        }
        System.out.println(sum);
        
        return numWaysToSplitArray;
    }
}
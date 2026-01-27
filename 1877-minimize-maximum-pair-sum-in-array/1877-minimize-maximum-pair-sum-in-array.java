class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;

        int minimumPairSum = Integer.MIN_VALUE;

        while(i < j){
            int currentPairSum = nums[i++] + nums[j--];
            minimumPairSum = Math.max(minimumPairSum, currentPairSum);
        }

        return minimumPairSum;
    }
}
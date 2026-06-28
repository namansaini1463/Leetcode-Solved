class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        int n = nums.length;

        Arrays.sort(nums);

        int idx = n-1;
        long totalValue = 0;

        for(int i = 0; i < k; i++){
            long element = nums[idx - i];

            totalValue += Math.max(element, element * mul--);
        }

        return totalValue;
    }
}
class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;

        int[] result = new int[2*n];
        int i = 0;

        for(; i < n; i++){
            result[i] = nums[i];
            result[n + i] = nums[n - i - 1];
        }

        return result;
    }
}
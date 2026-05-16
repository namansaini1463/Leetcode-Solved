class Solution {
    public int findMin(int[] nums) {
        int minimum = nums[0];
        for(int n : nums){
            minimum = Math.min(minimum, n);
        }

        return minimum;
    }
}
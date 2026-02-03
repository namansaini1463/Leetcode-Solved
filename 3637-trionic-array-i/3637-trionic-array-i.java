class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;

        int i = 0;
        while(i < n-1 && nums[i] < nums[i+1]) i++; // Check for initital increasing
        if(i == 0 || i == n-1) return false;

        while(i < n-1 && nums[i] > nums[i+1]) i++; // Check for decreasing 
        if(i == n-1) return false;

        while(i < n-1 && nums[i] < nums[i+1]) i++; // Check for last increasing
        if(i == n-1) return true;

        return false;
    }
}
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int longestIncreasingStreak = 1, longestDecreasingStreak = 1;
        int currentIncreasingStreak = 1, currentDecreasingStreak = 1;

        for(int i = 1; i < n; i++){
            if(nums[i-1] < nums[i]) currentIncreasingStreak++; 
            else {
                longestIncreasingStreak = Math.max(longestIncreasingStreak, currentIncreasingStreak);
                currentIncreasingStreak = 1;
            }


            if(nums[i-1] > nums[i]) currentDecreasingStreak++;
            else {
                longestDecreasingStreak = Math.max(longestDecreasingStreak, currentDecreasingStreak);
                currentDecreasingStreak = 1;
            }
        }

        return Math.max(Math.max(currentIncreasingStreak, currentDecreasingStreak), Math.max(longestIncreasingStreak, longestDecreasingStreak));
    }
}
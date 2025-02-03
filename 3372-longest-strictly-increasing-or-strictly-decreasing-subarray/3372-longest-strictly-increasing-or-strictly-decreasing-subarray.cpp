class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int maxIncreasing  = INT_MIN, currentIncreasing = 1;
        int maxDecreasing  = INT_MIN, currentDecreasing = 1;

        for(int i = 0; i < nums.size() - 1; i++){
            if(nums[i] < nums[i+1]){
                currentIncreasing++;
            } else {
                maxIncreasing = max(maxIncreasing, currentIncreasing);
                currentIncreasing = 1;
            }

            if(nums[i] > nums[i+1]){
                currentDecreasing++;
            } else {
                maxDecreasing = max(maxDecreasing, currentDecreasing);
                currentDecreasing = 1;
            }
        }
        
        maxIncreasing = max(maxIncreasing, currentIncreasing);
        maxDecreasing = max(maxDecreasing, currentDecreasing);

        return max(maxIncreasing, maxDecreasing);
    }
};
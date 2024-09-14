class Solution {
public:
    int longestSubarray(vector<int> &nums) {
        int maxi = INT_MIN;
        for (const auto &num : nums) {
            maxi = max(maxi, num);
        }

        int count = 0;
        int maxCount = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == maxi) {
            count++;
            } else {
            maxCount = max(maxCount, count);
            count = 0;
            }
        }
        maxCount = max(maxCount, count);

        return maxCount;
        } 
};
class Solution {
public:
    int rangeSum(vector<int>& nums, int n, int left, int right) {
        //finding all the subarray sums and storing them in an array
        vector<int> subArraySums;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int subArraySum = 0;
                for(int idx = i; idx <= j; idx++){
                    subArraySum += nums[idx];
                }
                subArraySums.push_back(subArraySum);
            }
        }

        sort(subArraySums.begin(), subArraySums.end());
        
        long long sum = 0;
        for(int i = left-1; i < right; i++){
            sum += subArraySums[i];
        }

        return static_cast<int>(sum % ((int)(1e9+7)));
    }
};
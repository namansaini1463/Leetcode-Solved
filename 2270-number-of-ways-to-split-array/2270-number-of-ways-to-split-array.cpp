class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        int count = 0;
        // Precalculating the sum of the array
        long long sum = 0;
        for(const auto &num : nums){
            sum += num;
        }

        long long accumulator = 0;
        for(int i = 0; i < nums.size() - 1; i++){
            accumulator += nums[i];

            if(accumulator >= sum - accumulator){
                count++;
            }
        }

        return count;
    }
};
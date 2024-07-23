class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n);

        if(n == 1) return {-1};

        for(int i = n-1; i >= 0; i--){
            for(int j = 1; j < n; j++){
                if(nums[(i+j)%n] > nums[i]){
                    result[i] = nums[(i+j)%n];
                    break;
                } else {
                    result[i] = -1;
                }
            }
        }

        return result;
    }
};
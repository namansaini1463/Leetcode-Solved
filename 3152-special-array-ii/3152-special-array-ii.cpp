class Solution {
public:
    vector<bool> isArraySpecial(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        if (n == 0) return {};

        //Creating an array that will store the parity of all the adjacent pairs. It will have a size of (n-1)
        vector<bool> parityPairArray(n-1);
        for(int i = 0; i < n - 1; i++){
            parityPairArray[i] = (nums[i]&1 ^ nums[i+1]&1); // Is true only when there is difference in the parity bits of the two numbers
        } 

        vector<int> cummulativeParitySum;
        cummulativeParitySum.push_back(0);

        for(const auto &parity : parityPairArray){
            cummulativeParitySum.push_back(cummulativeParitySum.back() + parity);
        }

        vector<bool> result;
        for(const auto &query : queries){
            int from_i = query[0];
            int to_i = query[1];

            int requiredSum = to_i - from_i;
            int paritySum = cummulativeParitySum[to_i] - cummulativeParitySum[from_i];

            result.push_back(requiredSum == paritySum);
        }       

        return result;
    }
};
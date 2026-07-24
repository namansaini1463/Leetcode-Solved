class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        int n = nums.size();

        unordered_set<int> xored;
        unordered_set<int> resultSet;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                xored.insert(nums[i] ^ nums[j]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int x : xored){
                resultSet.insert(x ^ nums[i]);
            }
        }

        return resultSet.size();    
    }
};
class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int i = 0, j = 0;
        int prod = 1;
        int count = 0;
        
        if(k == 0 or k == 1) return 0;
        
        while(j < nums.size()){
            prod = prod * nums[j];
            
            while(prod >= k){
                prod = prod / nums[i++];
            }
            
            count += j - i + 1;
            j++;
        }
        
        return count;
    }
};
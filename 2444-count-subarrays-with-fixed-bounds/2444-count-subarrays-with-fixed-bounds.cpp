class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        int mini = -1;
        int maxi = -1;
        long long ans = 0;
        int st = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] < minK or nums[i]>maxK){
                mini = -1;
                maxi = -1;
                st = i+1;
            }
            if(nums[i] == minK){
                mini = i;
            }
            if(nums[i] == maxK){
                maxi = i;
            }
            
            ans += max(0, min(mini,maxi) - st + 1);

        }
        
        return ans;
    }
};
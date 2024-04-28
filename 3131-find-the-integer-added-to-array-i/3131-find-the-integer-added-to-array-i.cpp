class Solution {
public:
    int addedInteger(vector<int>& nums1, vector<int>& nums2) {
        int maxi1 = INT_MIN, maxi2 = INT_MIN;
        for(int i = 0; i < nums1.size(); i++){
            maxi1 = max(maxi1, nums1[i]);
        }
        for(int i = 0; i < nums2.size(); i++){
            maxi2 = max(maxi2, nums2[i]);
        }

        return maxi2-maxi1;
        
    }
};
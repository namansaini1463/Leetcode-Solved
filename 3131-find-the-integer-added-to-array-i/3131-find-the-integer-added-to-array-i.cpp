class Solution {
public:
    int addedInteger(vector<int>& nums1, vector<int>& nums2) {
        /*
            Since the elements in both the arrays differ by the same number, we can sort the array and
            then the difference between the ith element of nums1 and nums2 will always be the same
            - OR
                We can find the largest(or smallest) numers in the array and return their difference
        */

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
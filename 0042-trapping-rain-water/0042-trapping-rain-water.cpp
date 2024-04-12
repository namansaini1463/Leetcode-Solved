class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        /*
            PrefixMax Stores the height of the largest pillar towards the left of the current pillar (current incluing)
            SuffixMax Stores the height of the largest pillar towards the right of the current pillar (current incluing)
        */
        vector<int> prefixMax(n);
        prefixMax[0] = height[0];
        
        vector<int> suffixMax(n);
        suffixMax[n-1] = height[n-1];

        for(int i = 1; i < n; i++){
            prefixMax[i] = height[i] > prefixMax[i-1] ? height[i] : prefixMax[i-1];
        }
        for(int i = n-2; i >= 0; i--){
            suffixMax[i] = height[i] > suffixMax[i+1] ? height[i] : suffixMax[i+1];
        } 

        int waterTrapped = 0;
        for(int i = 0; i < n; i++){
            waterTrapped += min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return waterTrapped;
    }
};
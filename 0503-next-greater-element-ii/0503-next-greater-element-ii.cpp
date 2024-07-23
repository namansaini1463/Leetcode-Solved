class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        /*
            TC: O(n)
            SC: O(n)
        */

        int n = nums.size();
        vector<int> result(n); 
        stack<int> st;

        // Iterating through the array twice to simulate the circular behavior
        for (int i = 2 * n - 1; i >= 0; --i) {
            while (!st.empty() and nums[i % n] >= st.top()) {
                st.pop();
            }

            if (i < n) {
                if (!st.empty()) {
                    result[i] = st.top();
                } else {
                    result[i] = -1;
                }
            }

            st.push(nums[i % n]);
        }

        return result;
    

        
        /*

        TC : O(n^2)
        SC : O(1)

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
        */
    }
};
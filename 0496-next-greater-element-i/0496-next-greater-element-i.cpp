class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> nextGreaterElements;
        stack<int> st;

        for(int i = nums2.size()-1; i >= 0; i--){
            while(!st.empty() and nums2[i] > st.top()){
                st.pop();
            }
            if(st.empty()){
                nextGreaterElements[nums2[i]] = -1;
                st.push(nums2[i]);
            } else {
                nextGreaterElements[nums2[i]] = st.top();
                st.push(nums2[i]);
            }
        }

        for(const auto &i : nextGreaterElements) cout << i.first << " " << i.second << endl;
        cout << endl;

        vector<int> result;

        for(const auto &num : nums1){
            result.push_back(nextGreaterElements[num]);
        }

        return result;
    }
};
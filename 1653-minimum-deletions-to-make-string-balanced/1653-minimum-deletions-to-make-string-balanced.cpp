class Solution {
public:
    int minimumDeletions(string s) {
        int deletionsCount = 0;
        stack<char> st;

        for(int i = 0; i < s.size(); i++){
            if(!st.empty() and s[i] == 'a' and st.top() == 'b'){
                st.pop();
                deletionsCount++;
            } else {
                st.push(s[i]);
            }
        }

        return deletionsCount;
    }
};
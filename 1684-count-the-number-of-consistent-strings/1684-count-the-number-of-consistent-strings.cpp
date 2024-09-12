class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        unordered_set<char> st;
        for(const auto &ch : allowed){
            st.insert(ch);
        }

        int count = 0;
        for(const auto &word : words){
            count++;
            for(const auto &ch : word){
                if(st.find(ch) == st.end()) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
};
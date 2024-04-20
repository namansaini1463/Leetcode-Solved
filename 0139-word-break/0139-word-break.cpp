class Solution {
public:
    unordered_set<string> dict;
    unordered_map<int, bool> memo;

    bool wordBreakUtil(int index, const string& s) {
        if (index == s.size()) return true;
        if (memo.find(index) != memo.end()) return memo[index];

        for (int len = 1; index + len <= s.size(); ++len) {
            string subString = s.substr(index, len);
            if (dict.find(subString) != dict.end() && wordBreakUtil(index + len, s))
                return memo[index] = true;
        }

        return memo[index] = false;
    }

    bool wordBreak(string s, vector<string>& wordDict) {
        for (const auto& word : wordDict) dict.insert(word);
        
        return wordBreakUtil(0, s);
    }
};
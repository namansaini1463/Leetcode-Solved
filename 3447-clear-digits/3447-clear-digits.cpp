class Solution {
public:
    string clearDigits(string s) {
        string result = "";

        for(int i = 0; i < s.size(); i++){
            if(isalpha(s[i])) result.push_back(s[i]);
            if(isdigit(s[i])) result.pop_back();
        }

        return result;
    }
};
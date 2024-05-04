class Solution {
public:
    string reversePrefix(string word, char ch) {
        string result;
        bool flag = true;
        for(const auto &chr : word){
            if(flag){
                result = chr + result;
                if(chr == ch) flag = false;
            } else {
                result = result + chr;
            }
        }
        
        if(flag) return word;
        return result;
    }
};
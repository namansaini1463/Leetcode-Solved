class Solution {
public:
    bool canConstruct(string s, int k) {
        if(s.size() < k) return false;
        if(s.size() == k) return true;

        int count[26] = {0};

        for(int i = 0; i < s.size(); i++){
            count[s[i] - 'a'] ^= 1;
        }

        int oddChars = 0;
        for(const auto &i : count){
            oddChars += i;
        }  


        return oddChars <= k ? true : false;
    }
};


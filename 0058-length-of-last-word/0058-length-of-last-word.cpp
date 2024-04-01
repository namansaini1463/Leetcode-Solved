class Solution {
public:
    int lengthOfLastWord(string s) {
        int i = 0, j = 0;
        int lastWordLength = 0;
        for(; j < s.size(); j++){
            while(s[j] == ' ' and j < s.size()) j++;
            if(j == s.size()) return lastWordLength;
            
            i = j;

            while(s[j] != ' ' and j < s.size()) j++;
            lastWordLength = j - i;
        }

        return lastWordLength;
    }
};
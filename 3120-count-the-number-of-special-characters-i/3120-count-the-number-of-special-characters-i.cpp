class Solution {
public:
    int numberOfSpecialChars(string word) {
        bool capitals[26];
        bool smalls[26];
        fill_n(capitals, 26, false);
        fill_n(smalls, 26, false);

        for(const char &ch : word){
            if(ch - 'a' < 0) capitals[ch-'A'] = true;
            else smalls[ch-'a'] = true;
        }

        int count = 0;
        for(int i = 0; i < 26; i++){
            if(smalls[i] and capitals[i]) count++;
        }

        return count;
    }
};
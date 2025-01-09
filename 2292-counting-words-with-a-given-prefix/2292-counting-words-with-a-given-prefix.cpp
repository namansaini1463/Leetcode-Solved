class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int count = 0;

        for(const auto &word : words){
            count++;
            for(int i = 0; i < pref.size(); i++){
                if(pref[i] != word[i]){
                    count--;
                    break;
                }
            }
        }
        
        return count;
    }
};
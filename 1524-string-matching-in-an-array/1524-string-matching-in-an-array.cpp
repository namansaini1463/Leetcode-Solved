class Solution {
    
public:
    vector<string> stringMatching(vector<string>& words) {
        vector<string> result;
        unordered_set<string> resultSet;

        for(int i = 0; i < words.size(); i++){
            for(int j = 0; j < words.size(); j++){
                if(i == j) continue;

                if(words[i].find(words[j]) != string::npos){
                   resultSet.insert(words[j]);
                }
            }
        }

        for(const auto &word : resultSet){
            result.push_back(word);
        }

        return result;
    }
};
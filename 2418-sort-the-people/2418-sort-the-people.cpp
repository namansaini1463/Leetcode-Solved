class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        map<int, string> map;

        for(int i = 0; i < names.size(); i++){
            map.insert({heights[i], names[i]});
        }

        vector<string> result;
        for(auto it = map.begin(); it != map.end(); it++){
            result.push_back(it->second);
        }

        reverse(result.begin(), result.end());

        return result;
    }
};
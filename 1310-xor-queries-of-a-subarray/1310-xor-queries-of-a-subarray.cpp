class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        vector<int> prefixXOR;
        prefixXOR.push_back(0);

        for(const auto &a : arr){
            prefixXOR.push_back(prefixXOR.back() ^ a);
        }    

        vector<int> result;
        for(const auto& query: queries){
            result.push_back(prefixXOR[query[0]] ^ prefixXOR[query[1]+1]);
        }    
       
        return result;
    }
};
class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        int n = edges.size() + 1;
        vector<int> degree(n+1);

        for(const auto &edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        for(int i = 0; i < n+1; i++){
            if(degree[i] > 1) return i;
        }
        
        return -1;
    }
};
class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        sort(edges.begin(), edges.end());
        vector<set<int>> ancestors(n);
        for(const auto &edge : edges){
            int src = edge[0];
            int dst = edge[1];

            if(!ancestors[src].empty()){
                for(auto itr = ancestors[src].begin(); itr != ancestors[src].end(); itr++){
                    ancestors[dst].insert(*itr);
                }
            }

            ancestors[dst].insert(src);
        }

        vector<vector<int>> result(n);
        for(int i = 0; i < n; i++){
            for(auto itr = ancestors[i].begin(); itr != ancestors[i].end(); itr++){
                result[i].push_back(*itr);
            }
        }

        return result;
    }
};
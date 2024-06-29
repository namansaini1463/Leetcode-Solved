class Solution {
private:
    void dfs(int current, int parent, vector<bool> &visited, vector<vector<int>> &ancestors, vector<vector<int>> &graph){
        visited[current] = true;

        for(const auto &node : graph[current]){
            if(!visited[node]){
                ancestors[node].push_back(parent);
                dfs(node, parent, visited, ancestors, graph);
            }
        }
    }

public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        for(const auto &edge : edges){
            int src = edge[0];
            int dst = edge[1];

            graph[src].push_back(dst);
        }

        vector<vector<int>> ancestors(n);

        for(int parent = 0; parent < n; parent++){
            vector<bool> visited(n, false);
            dfs(parent, parent, visited, ancestors, graph);
        }

        return ancestors;
    }
};
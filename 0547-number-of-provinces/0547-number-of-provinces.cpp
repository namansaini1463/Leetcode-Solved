class Solution {
private:
    void dfs(int node, vector<int> adj[], vector<bool> &visited){
        visited[node] = true;
        
        for(auto adjacentNode : adj[node]){
            if(!visited[adjacentNode]){
                dfs(adjacentNode, adj, visited);
            }
        }
    }
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<int> adj[n];

        /*
            Creating the adjacency list from the given adjacency matrix
        */
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] and i != j){
                    adj[i].push_back(j);
                    // adj[j].push_back(i);
                }
            }
        }

        vector<bool> visited(n, false);
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, adj, visited);
                provinces++;
            }
        }

        return provinces;
    }
};
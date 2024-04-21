class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<int> adj[n];

        // Making the adjacency list from the given edges
        for(auto &edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        bool visited[n];
        fill_n(visited, n, false);

        queue<int> q;
        q.push(source);
        visited[source] = true;

        while(!q.empty()){
            int node = q.front(); q.pop();

            for(auto &adjNode : adj[node]){
                if(!visited[adjNode]){
                    q.push(adjNode);
                    visited[adjNode] = true;
                }
            }
        }

        return visited[destination];
    }
};
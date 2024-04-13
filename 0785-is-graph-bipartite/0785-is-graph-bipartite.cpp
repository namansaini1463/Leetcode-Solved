class Solution {
private:
    bool checkBipartite(int node, vector<vector<int>> &graph, int color[]){
        queue<int> q;
        q.push(node); color[node] = 0;

        while(!q.empty()){
            int n = q.front(); q.pop();

            for(auto adj : graph[n]){
                if(color[adj] == -1){
                    q.push(adj);
                    color[adj] = !color[n]; 
                } else if(color[adj] == color[n]){
                    return false;
                }
            }
        }

        return true;
    }
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int V = graph.size();

        int color[V];
        fill_n(color, V, -1);

        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(!checkBipartite(i, graph, color)) return false;
            }
        }

        return true;
    }
};
class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        // Making the graph in the form of an adjacency matrix
        vector<vector<int>> graph(n, vector<int>(n, INT_MAX));
        
        for(int i = 0; i < n; i++){
            graph[i][i] = 0;
        }

        for(const auto &edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u][v] = w;
            graph[v][u] = w;
        }

        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(graph[i][via] != INT_MAX and graph[via][j] != INT_MAX){
                        graph[i][j] = min(graph[i][j], graph[i][via] + graph[via][j]);
                    }
                } 
            }
        }

        int minNeighboursCount = INT_MAX;
        int cityWithSmallestNumberOfNeighbors = n;
        
        
        for(int i = 0; i < n; i++){
            int neighbourCount = 0;
            for(int j = 0; j < n; j++){
                if(graph[i][j] <= distanceThreshold) neighbourCount++;
            } 

            if(neighbourCount <= minNeighboursCount){
                minNeighboursCount = neighbourCount;
                cityWithSmallestNumberOfNeighbors = i;
            }
        }
        

        return cityWithSmallestNumberOfNeighbors;

    }
}; 
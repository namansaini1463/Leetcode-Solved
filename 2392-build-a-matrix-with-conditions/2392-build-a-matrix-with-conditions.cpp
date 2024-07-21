class Solution {
private:
    vector<int> topoSort(vector<vector<int>> &edges, int k){
        // Making the adjacency graph
        vector<vector<int>> graph(k);

        for(const auto &edge : edges){
            int src  = edge[0] - 1;  // Convert to 0-based index
            int dst = edge[1] - 1;   // Convert to 0-based index
            graph[src].push_back(dst);
        }

        vector<int> indegree(k, 0);
        for(int i = 0; i < k; i++){
            for(const auto &adjnode : graph[i]){
                indegree[adjnode]++;
            }
        }

        vector<int> sortedOrder;
        queue<int> q;

        for(int i = 0; i < k; i++){
            if(indegree[i] == 0) q.push(i);
        }

        while(!q.empty()){
            int node = q.front();
            q.pop();

            sortedOrder.push_back(node);

            for(const auto &adjNode : graph[node]){
                indegree[adjNode]--;

                if(indegree[adjNode] == 0) q.push(adjNode);
            }
        }

        // If sortedOrder doesn't include all nodes, there's a cycle
        if (sortedOrder.size() != k) return {};

        return sortedOrder;
    }
public:
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions, vector<vector<int>>& colConditions) {
        vector<int> rowTopoSort = topoSort(rowConditions, k);
        vector<int> colTopoSort = topoSort(colConditions, k);

        if(rowTopoSort.empty() || colTopoSort.empty()) return {};

        vector<vector<int>> result(k, vector<int>(k, 0));
        
        vector<int> rowPos(k), colPos(k);
        for (int i = 0; i < k; ++i) {
            rowPos[rowTopoSort[i]] = i;
            colPos[colTopoSort[i]] = i;
        }

        for (int i = 0; i < k; ++i) {
            result[rowPos[i]][colPos[i]] = i + 1;  // Convert back to 1-based index
        }

        return result;
    }
};

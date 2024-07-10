typedef pair<int, int> pii;

class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int src) {
        vector<vector<pii>> graph(n+1);

        for(const auto &time: times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            graph[u].push_back({v, t});
        }

        int delayTime[n+1];
        fill_n(delayTime, n+1, INT_MAX);

        delayTime[src] = 0;

        //min heap priority queue for dijkstra algorithm
        priority_queue<pii, vector<pii>, greater<pii>> pq;
        pq.push({0, src}); // {time, node}

        while(!pq.empty()){
            int time = pq.top().first;
            int currentNode = pq.top().second;
            pq.pop();

            for(const auto &adj : graph[currentNode]){
                int nextNode = adj.first;
                int nextNodeDelayTime = adj.second;

                if(delayTime[nextNode] > time + nextNodeDelayTime){
                    delayTime[nextNode] = time + nextNodeDelayTime;
                    pq.push({delayTime[nextNode], nextNode});
                }
            }
        }

        
        int minimumTimeToReachAllNodes = INT_MIN;
        for(int i = 1; i <= n; i++){
            minimumTimeToReachAllNodes = max(minimumTimeToReachAllNodes, delayTime[i]);
        } 

        return minimumTimeToReachAllNodes == INT_MAX ? -1 : minimumTimeToReachAllNodes;
    }
};
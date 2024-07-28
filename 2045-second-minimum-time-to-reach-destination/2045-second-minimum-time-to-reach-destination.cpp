typedef pair<int, int> pii;
class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
         unordered_map<int, vector<int>> graph;
        
        for(const auto &edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].push_back(v);
            graph[v].push_back(u);
        }

        vector<int> minDistance(n+1, INT_MAX);
        vector<int> secondMinDistance(n+1, INT_MAX);

        queue<pii> pq;
        pq.push({0, 1});

        while(!pq.empty()){
            auto [timePassed, currentNode] = pq.front();
            pq.pop();

            if(currentNode == n and secondMinDistance[currentNode] != INT_MAX)
                return secondMinDistance[n];

            int currentSlot = timePassed/change;
            if(currentSlot % 2 == 1){ //currently in the red signal
                timePassed = change * (currentSlot + 1); // wait until the next region
            }

            for(const auto &adjNode : graph[currentNode]){
                if(minDistance[adjNode] > timePassed + time){
                    secondMinDistance[adjNode] = minDistance[adjNode];
                    minDistance[adjNode] =  timePassed + time;
                    pq.push({timePassed + time, adjNode});
                } else if(secondMinDistance[adjNode] > timePassed + time and 
                        minDistance[adjNode] != timePassed + time){
                      secondMinDistance[adjNode] = timePassed + time;      
                    pq.push({timePassed + time, adjNode});

                }
            }
        }

        return -1;

    }
};

/*
typedef pair<int, int> pii;
class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
         unordered_map<int, vector<int>> graph;
        
        for(const auto &edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].push_back(v);
            graph[v].push_back(u);
        }

        vector<int> minDistance(n+1, INT_MAX);
        vector<int> secondMinDistance(n+1, INT_MAX);

        priority_queue<pii, vector<pii>, greater<pii>> pq;
        pq.push({0, 1});

        while(!pq.empty()){
            auto [timePassed, currentNode] = pq.top();
            pq.pop();

            if(currentNode == n and secondMinDistance[currentNode] != INT_MAX)
                return secondMinDistance[n];

            int currentSlot = timePassed/change;
            if(currentSlot % 2 == 1){ //currently in the red signal
                timePassed = change * (currentSlot + 1); // wait until the next region
            }

            for(const auto &adjNode : graph[currentNode]){
                if(minDistance[adjNode] > timePassed + time){
                    secondMinDistance[adjNode] = minDistance[adjNode];
                    minDistance[adjNode] =  timePassed + time;
                    pq.push({timePassed + time, adjNode});
                } else if(secondMinDistance[adjNode] > timePassed + time and 
                        minDistance[adjNode] != timePassed + time){
                      secondMinDistance[adjNode] = timePassed + time;      
                    pq.push({timePassed + time, adjNode});

                }
            }
        }

        return -1;

    }
};
*/
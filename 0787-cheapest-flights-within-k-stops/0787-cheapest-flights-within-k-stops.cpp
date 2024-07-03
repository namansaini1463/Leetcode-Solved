typedef pair<int, int> pii;
typedef pair<int, pii> pipii;

class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        // Making the adjacency graph
        vector<vector<pii>> graph(n);

        for(const auto &flight: flights){
            int from = flight[0]; 
            int to = flight[1]; 
            int price = flight[2];

            graph[from].push_back({to, price}); 
        }

        int cost[n];
        fill_n(cost, n, INT_MAX);
        cost[src] = 0;

        // Min heap: {cost, currentNode, moves}
        priority_queue<pipii, vector<pipii>, greater<pipii>> pq;
        pq.push({0, {src, 0}});

        while(!pq.empty()){
            int currentCost = pq.top().first;
            int current = pq.top().second.first;
            int moves = pq.top().second.second;
            pq.pop();

            if(current == dst) return currentCost;
            
            if(moves <= k){
                for(const auto &next : graph[current]){
                    int to = next.first;
                    int price = next.second;

                    int newCost = currentCost + price;
                    if(newCost < cost[to]){
                        cost[to] = newCost;
                        pq.push({newCost, {to, moves + 1}});
                    }
                }
            }
        }

        return -1;
    }
};
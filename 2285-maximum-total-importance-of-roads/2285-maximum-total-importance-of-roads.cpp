class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        //Finding the degree of each node
        vector<int> degree(n, 0);

        for(const auto &road: roads){
            int src = road[0];
            int dst = road[1];

            degree[src]++;
            degree[dst]++;
        }

        /*
            Making a max heap and pushing the degree of the node and the node in it. 
            This is done to assign the node with the integer from 1 to n. (importance value)
            Node with the highest degree will have more value
        */

        priority_queue<pair<int, int>> pq;
        for(int i = 0; i < n; i++){
            pq.push({degree[i], i});
        }

        vector<int> importance(n);
        int importanceValue = n;
        while(!pq.empty()){
            int index = pq.top().second;
            pq.pop();
            importance[index] = importanceValue;
            importanceValue--;
        }

        /*
            Find the maximum importance value of the roads.
            The max imp val is the sum of the importance value for the src and dst of each road
        */

        long long maximumImportanceValue = 0;
        for(const auto &road: roads){
            int src = road[0];
            int dst = road[1];


            maximumImportanceValue += importance[src] + importance[dst];
        }

        // for(const auto &i : degree) cout << i << " ";
        // cout << endl;

        return maximumImportanceValue;
    }
};
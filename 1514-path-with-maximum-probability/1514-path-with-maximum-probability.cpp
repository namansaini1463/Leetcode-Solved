typedef pair<double, int> pdi;

class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start_node, int end_node) {
        // Making the adjacency weighted graph
        vector<vector<pair<int, double>>> graph(n);

        // Build the graph using the edges and success probabilities
        for (int i = 0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];
            
            graph[u].push_back({v, wt});
            graph[v].push_back({u, wt});
        }

        // Storing the probabilities of each node
        vector<double> probabilities(n, 0.0);

        priority_queue<pdi> pq; //max heap iss liye bnaya kyuki humme high probability desired hai

        // Initialize the starting node
        pq.push({1.0, start_node});
        probabilities[start_node] = 1.0;

        while (!pq.empty()) {
            auto [probability, currentNode] = pq.top();
            pq.pop();

            for (const auto &[nextNode, nextProbability] : graph[currentNode]) {
                double newProbability = probability * nextProbability;
                if (probabilities[nextNode] < newProbability) {
                    probabilities[nextNode] = newProbability;
                    pq.push({newProbability, nextNode});
                }
            }
        }

        return probabilities[end_node];
    }
};

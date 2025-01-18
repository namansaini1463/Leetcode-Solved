class Solution {
 public:
  int minCost(vector<vector<int>> &grid) {
    int n = grid.size(), m = grid[0].size();

    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<>> pq;  // {cost, {x, y}}
    vector<vector<int>> minCost(n, vector<int>(m, INT_MAX));  

    vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    pq.push({0, {0, 0}});
    minCost[0][0] = 0;

    while (!pq.empty()) {
      auto [cost, pos] = pq.top();
      pq.pop();

      int x = pos.first, y = pos.second;

      if (x == n - 1 and y == m - 1) return cost;

      for (int i = 1; i <= 4; i++) {
        int newX = x + directions[i-1].first;
        int newY = y + directions[i-1].second;

        if (newX >= 0 and newX < n and newY >= 0 and newY < m) {
          int newCost = cost + (grid[x][y] == i ? 0 : 1);  // Current cell jis direction mei lekr jaara hai usski cost 0 hi rahegi, else +1

          // Update the cost if a lower cost path is found (dijkstra approach)
          if (newCost < minCost[newX][newY]) {
            minCost[newX][newY] = newCost;
            pq.push({newCost, {newX, newY}});
          }
        }
      }
    }

    return -1; 
  }
};
